#! /usr/bin/env ruby
#
# Convertor of confluence pages to asciidoc
#
# usage confluence2asciidoc 'Wiki page name'
# output will be in the "out" directory
#
# (C) 2020-2021 Evolveum
# Author: Radovan Semancik
#
# Licensed under the terms of Apache License
#
# NOTE: This is a quick and dirty script.
# It is meant to be a throw-away thing, for one-time migration from Confluence to Asciidoc.
# The code is ugly, it does not handle all cases, but it works.
# A have migrated all pageses one-by-one, visually checking all of them,
# adjusting the formatiing manually.
# It was not worth to invest too much time in this script, as the WYSIWYG nature
# of confluence will not allow a perfect conversion anyway.
#
#

require 'rubygems'
require 'json'
require 'faraday'
require 'nokogiri'
require 'open-uri'
require 'net/http'
require 'fileutils'

$username = "robot"
$password = "XXXXXXXXXXXXXX"
$spaceName = 'midPoint'
$wikiUrl = 'https://wiki.evolveum.com/'
$pageTitle = "NONAME"
$outputDir = "out"
$outFile

def parseFile(filename)
	inputFile = File.open(filename)
	data = inputFile.read
	parseDoc(data, nil)
end

def parseWiki(title)
	$pageTitle = title
	data = getWikiPage(title)
	if data == nil
		return
	end
	parseDoc(data, title)
end

def parseDoc(data, pageName)
	begin
		FileUtils.mkdir_p $outputDir
		outFileBase = $pageTitle.downcase.gsub(/\W/,' ').gsub(/\s+/,'-')
		outFilePath = $outputDir + "/" + outFileBase + ".adoc"
		puts "Output file: #{outFilePath}"
		$outFile = File.open(outFilePath, "w")

		$outFile.write("= " + $pageTitle + "\n")
		
		if pageName
		    $outFile.write(":page-wiki-name: #{pageName}\n")
		end
		$outFile.write("\n")

		data = data.gsub(/&nbsp;/, ' ')
		doc = Nokogiri::XML("<root>"+data+"</root>")
		
		children = doc.root.children
		
		parseChildren(children)

	ensure
	  $outFile.close unless $outFile.nil?
	end
end

def parseChildren(children)
	children.each { |node|
		if node.element? then
			parseElement(node)
		elsif node.text? then
			if !node.content.strip.empty? then
				convertText(node.content)
				$outFile.write("\n\n")
#				error("NON EMPTY TEXT: #{node.content}")
			end
		else
			error("Unknown child node #{node.name}")
		end
	}
end

def parseP(element)
#	puts "DDDDD P: #{element.content}"
	convertTextChildren(element, 0)
	$outFile.write("\n\n")
end

def convertTextChildren(element, listLevel)
	element.children.each { |node|
		if node.text?
#			puts "TTTTT: #{node.content}"
			if !node.content.strip.empty?
				convertText(node.content)
			end
		elsif node.element?
			convertTextElement(node, listLevel)
		else
			error("Unknown text node #{node}")
		end
	}
end

def convertText(inputString)
	$outFile.write(splitSentences(escape(inputString)))
end


def convertQuotedNode(element, mark)
	if element.children.any? { |subnode| subnode.element? }
		$outFile.write(mark)
		convertTextChildren(element, 0)
		$outFile.write(mark)
	else
		convertQuotedText(element.content, mark)
	end
end

def convertQuotedText(inputString, mark)
	$outFile.write("#{mark}#{inputString}#{mark}")
end


def escape(inputString)
	out = escapeChar(inputString,"_")
	escapeChar(out,"*")
end

def escapeChar(inputString,char)
	return inputString.gsub(/(#{Regexp.escape(char)}+)/, '\\\\\1')
end

def splitSentences(inputString)
#	return inputString.scan(/[^\.!?]+[\.!?]\s+/).join("\n")
	return inputString.gsub(/(\w\S\.) +/, "\\1\n")
end

def parseEmoticon(element)
	case element['ac:name']
	when "question"
		$outFile.write("(?)")
	when "warning"
		$outFile.write("⚠")
	when "tick"
		$outFile.write("🗸")
	when "smile"
		$outFile.write("☺")
	else
		error("Unknown emoticon #{element['ac:name']}")
	end
end


def convertTextElement(element, listLevel)
	case element.name
	when "ac:structured-macro", "structured-macro"
		parseMacro(element)
	when "a"
		parseA(element)
	when "ac:link", "link"
		parseLink(element)
	when "em"
		convertQuotedNode(element,"_")
	when "strong"
		convertQuotedNode(element,"*")
	when "u"
		$outFile.write("[.underline]")
		convertQuotedNode(element,"#")
	when "s"
		$outFile.write("[.line-through]")
		convertQuotedNode(element,"#")
	when "sub"
		convertQuotedNode(element,"~")
	when "sup"
		convertQuotedNode(element,"^")
	when "span"
		parseSpan(element)
	when "code", "pre"
		convertQuotedNode(element,"`")
	when "br"
		$outFile.write(" +\n")
	when "ul"
        $outFile.write("\n\n")
		parseList(element, '*', listLevel + 1)
	when "ol"
        $outFile.write("\n\n")
		parseList(element, '.', listLevel + 1)
	when "p"
		convertTextChildren(element, listLevel)
	when "div"
		convertTextChildren(element, listLevel)
	when "h1"
		parseH(element,"==")
	when "h2"
		parseH(element,"===")
	when "h3"
		parseH(element,"====")
	when "h4"
		parseH(element,"=====")
	when "h5"
		parseH(element,"======")
	when "table"
		parseTable(element)
	when "hr"
		$outFile.write("'''\n")
	when "ac:image", "image"
		parseImage(element)
	when "ac:emoticon"
		parseEmoticon(element)
	else
		error("Unknown text element: #{element.name}")
	end
end

def parseSpan(element)
	if element.attributes.empty?
		$outFile.write(element.content)
		return
	end

	spanclass = element["class"]
	if spanclass
		case spanclass
		when "Object"
			convertTextChildren(element, 0)
		when "Apple-tab-span"
			$outFile.write("\t")
		when "s1", "pl-s1", "pl-pds"  # seems not to mean anything
			$outFile.write(element.content)
		when "issue-link"  # seems not to mean anything
			$outFile.write(element.content)
		when "fullname"  # seems not to mean anything
			$outFile.write(element.content)
		when "nolink"  # probably to avoi automatic hyperlinking. Do we need to do anything special in asciidoc?
			$outFile.write(element.content)
		when "summary"  # Used in Jira URLs
			$outFile.write(element.content)
		when "confluence-link"
		    convertTextChildren(element, 0)
		when "aui-lozenge aui-lozenge-subtle aui-lozenge-complete jira-macro-single-issue-export-pdf"
			# Used in Jira URLs, contains status e.g "OPEN".
			# We do not want to migrate that. Do nothing.
			
		when "blob-code-inner blob-code-marker-addition", "blob-code-inner blob-code-marker-deletion", "blob-code-inner blob-code-marker-context"
			# Some change tracking? Probaby not important
			$outFile.write(element.content)
		when "pl-smi"
			# Not sure what this means ...
			$outFile.write(element.content)
		when "short_text"
			# Does not seem to anything
			$outFile.write(element.content)
		else
			warn("Unknown span class #{spanclass}")
			$outFile.write(element.content)
		end

	else

		style = element["style"]
		if style
			case style
			when "color: rgb(128,0,0);", "color: red;"
				$outFile.write("[.red]")
				convertQuotedNode(element,"#")
			when "color: rgb(0,128,0);", "color: green;"
				$outFile.write("[.green]")
				convertQuotedNode(element,"#")
			when "color: rgb(0,0,128);", "color: blue;"
				$outFile.write("[.blue]")
				convertQuotedNode(element,"#")
			when "color: rgb(0,0,0);", "color: black;"
				$outFile.write(element.content)
			when "letter-spacing: 0.0px;"
				$outFile.write(element.content)
			when "text-decoration: underline;"
				$outFile.write("[.underline]")
				convertQuotedNode(element,"#")
			else
				if style.start_with?("color: rgb(")
					# Ignore other colors, we do not want a circus
					$outFile.write(element.content)
				else
					warn("Unknown span style #{style}")
					$outFile.write(element.content)
				end
			end
		else
			error("Span element empty? #{element.content}")
		end
	end
			
end

def parseMacro(element)
	macroName = element["ac:name"]
	case macroName
	when "toc"
		$outFile.write("\n:page-toc: top\n\n")
	when "code"
		parseCodeBlock(element)
	when "info", "tip"
		parseAdmonition(element,"TIP")
	when "note"
		parseAdmonition(element,"NOTE")
	when "warning"
		parseAdmonition(element,"WARNING")
	when "jira"
		parseJira(element)
	when "noformat"
		parseCodeBlock(element)
	when "panel"
		parsePanel(element)
	when "include"
		parseInclude(element)
	when "children"
		$outFile.write("\n\n++++\n{% children %}\n++++\n\n")
	else
		error("Unknown macro #{macroName}")
	end
end

def parseCodeBlock(element)
	language="text"
	code="XXXXX"
	title=""
	element.children.each { |node|
		if node.element?
			case node.name
			when "ac:parameter", "parameter"
				case node["ac:name"]
				when "language"
					if node.content == "html/xml"
						language = "xml"
					else
						language = node.content
					end
				when "title"
					title = node.content
				when "collapse"
					# We do not have ability to collapse source, just ignore it
				when "linenumbers"
					# We do not have the ability ...
				when "1"
					# Looks like an ancient way how to set the title.
					# Just make sure not to overwrite a better title
					if title == ""
						title = node.content
					end
				when ""
					# Guesswork
					case node.content
						when "java"
							language = "java"
						when "xml"
							language = "xml"
						when "none", "plain"
							# Nothing, really
						else
							warn("Unrecognized empty-name code parameter value #{node.content}")
						end
				else
					error("Unknown code parameter #{node}")
				end
			when "ac:plain-text-body", "plain-text-body"
				code = node.content
			else
				error("Unknown code element #{node.name}")
			end
		else
			error("Unknown code node #{node}")
		end
	}

	if !title.strip.empty?
		$outFile.write(".#{title}\n")
	end
	if language == "text"
		$outFile.write("[source]\n")
	else
		$outFile.write("[source,#{language}]\n")
	end
	$outFile.write("----\n")
	$outFile.write(code)
	$outFile.write("\n----\n\n")
end

def parseAdmonition(element,type)
	$outFile.write("[#{type}]\n")
	element.children.each { |node|
		if node.element?
			case node.name
			when "ac:parameter", "parameter"
				case node["ac:name"]
				when "title"
					$outFile.write(".#{node.content}\n")
				else
					error("Unknown admonition parameter #{node}")
				end
			when "ac:rich-text-body", "rich-text-body"
				$outFile.write("====\n")
				parseChildren(node.children)
				$outFile.write("====\n\n")
			when "ac:plain-text-body", "plain-text-body"
				$outFile.write("====\n")
				convertText(node.content)
				$outFile.write("====\n\n")
			else
				error("Unknown admonition element #{node.name}")
			end
		else
			error("Unknown admonition node #{node}")
		end
	}

end

def parsePanel(element)
	element.children.each { |node|
		if node.element?
			case node.name
			when "ac:parameter", "parameter"
				case node["ac:name"]
				when "title"
					$outFile.write(".#{node.content}\n")
				else
					error("Unknown PANEL parameter #{node}")
				end
			when "ac:rich-text-body", "rich-text-body"
				$outFile.write("****\n")
				parseChildren(node.children)
				$outFile.write("****\n\n")
			when "ac:plain-text-body", "plain-text-body"
				$outFile.write("****\n")
				convertText(node.content)
				$outFile.write("****\n\n")
			else
				error("Unknown PANEL element #{node.name}")
			end
		else
			error("Unknown PANEL NODE #{node}")
		end
	}

end


def parseJira(element)
	key=""
	element.children.each { |node|
		if node.element?
			case node.name
			when "ac:parameter", "parameter"
				case node["ac:name"]
				when "key"
					key = node.content
				end
			else
				error("Unknown JIRA ELEMENT #{node.name}")
			end
		else
			error("Unknown JIRA NODE #{node}")
		end
	}

	if key
#		$outFile.write("https://jira.evolveum.com/browse/#{key}[#{key}]")
		$outFile.write("bug:#{key}[]")
	else
		error("Jira without key: #{element}")
	end
end

def parseInclude(element)
	page=nil
	element.children.each { |node|
		if node.element?
			case node.name
			when "ac:parameter", "parameter"
				case node["ac:name"]
				when ""
					# Nameless paramenter contains link to the page
					page = extractIncludePageName(node)
				else
					error("Unknown include macro parameter #{node["ac:name"]}")
				end
			else
				error("Unknown include macro ELEMENT #{node.name}")
			end
		else
			error("Unknown include macro NODE #{node}")
		end
	}

	if page
		warn("Processing include of page #{page}")
		escapedPageName = page.gsub(/ /, "-").downcase
		$outFile.write("include::#{escapedPageName}.adoc[]")
	else
		error("Include without page: #{element}")
	end
end


def extractIncludePageName(element)
	pageNode = element.children
		.select{|node| node.name == "ac:link"}[0]
		.children
			.select{|node| node.name == "ri:page"}[0]
	pageNode['ri:content-title']
end

def parseA(element)
	linkUri=element["href"]
	linkText=element.content
	createLink(linkUri, linkText)
end

def parseLink(element)
	pageName = nil
	linkText = nil
	filename = nil
	element.children.each { |node|
		if node.element?
			case node.name
			when "ri:page"
				pageName = node["ri:content-title"]
				linkText = node["ri:content-title"]
			when "ac:plain-text-link-body", "plain-text-link-body", "ac:link-body"
				linkText = node.content
			when "ri:attachment"
				filename = node["ri:filename"]
			else
				error("Unknown LINK ELEMENT #{node.name}")
			end
		else
			error("Unknown LINK NODE #{node}")
		end
	}
	if filename != nil
		# We have an attachment link, this is special case
		mangledFilename = getWikiAttachment($pageTitle, filename)
		$outFile.write("xref:#{mangledFilename}[#{mangledFilename}]")
	else
		if pageName == nil
			pageName = element["ac:anchor"]
		end
		if pageName == nil
			# Link without a target? It may happen. Just write the text ...
			warn("No link target: #{element}")
			$outFile.write(linkText)
		else
		    escapedPageName = pageName.gsub(/ /, "+")
		    $outFile.write("wiki:#{escapedPageName}[#{linkText}]")
		end
	end
end

def createLink(linkUri, linkText)
	if isWikiUrl(linkUri)
	    pageName = getWikiPageName(linkUri)
	    if pageName == nil
	        # strange .... is there pageId?
	        warn("Non-wiki wiki link: #{linkUri}")
	        $outFile.write("link:#{linkUri}[#{linkText}]")    
	    else
	        escapedPageName = pageName.gsub(/ /, "+")
    #	    puts("LINK: #{linkUri} WIKI -> #{escapedPageName}")
	        $outFile.write("wiki:#{escapedPageName}[#{linkText}]")
	    end
	elsif isDocsUrl(linkUri)
	    localUri = transformDocsUri(linkUri)
#	    puts("LINK: #{linkUri} DOCS -> #{localUri}")
	    $outFile.write("link:#{localUri}[#{linkText}]")
	else
#    	puts("LINK: #{linkUri} ordinary")
	    $outFile.write("link:#{linkUri}[#{linkText}]")
	end
end

def isWikiUrl(uri)
	return uri =~ /^https:\/\/wiki.evolveum.com\//
end

def getWikiPageName(uri)
    m = uri.match(/^https:\/\/wiki.evolveum.com\/display\/midPoint\/([^\/]+)/)
    if m == nil
        return nil
    elsif m[1]
        return m[1]
    else
        error("unknown wiki link #{uri}")
        return "UNKNOWN"
    end
end

def isDocsUrl(uri)
	return uri =~ /^https:\/\/docs.evolveum.com\//
end

def transformDocsUri(uri)
    m = uri.match(/^https:\/\/docs.evolveum.com\/(.*)$/)
    if m[1]
        return "/" + m[1]
    else
        puts("WARNING: unknown docs link #{uri}")
        return uri
    end
end


def parseImage(element)
	filename="XXXXX"
	element.children.each { |node|
		if node.element?
			case node.name
			when "ri:attachment", "attachment"
				filename = node["ri:filename"]
			else
				error("Unknown image element #{node.name}")
			end
		else
			error("Unknown image node #{node}")
		end
	}
	mangledFilename = getWikiAttachment($pageTitle, filename)
	$outFile.write("image::#{mangledFilename}[]\n\n")
end


def parseH(element,prefix)
	$outFile.write("\n#{prefix} #{element.content}\n\n")
end

def parseList(element, prefix, listLevel)
	element.children.each { |node|
		if node.element?
			case node.name
			when "li"
				for i in 0..listLevel
					$outFile.write("#{prefix}")
				end
				$outFile.write(" ")
				convertTextChildren(node, listLevel)
				$outFile.write("\n\n")
			else
				error("Unknown LIST ELEMENT #{node.name}")
			end
		elsif node.text?
			if !node.content.strip.empty? then
				error("Unknown LIST NON EMPTY TEXT: #{node.content}")
			end
		else
			error("Unknown LIST NODE #{node}")
		end
	}
end

def parseTable(element)
	element.children.each { |node|
		if node.element?
			case node.name
			when "thead"
				parseTableWithTHead(element)
				break
			when "tbody"
				parseTableBody(node)
			when "colgroup"
				# pretty much safe to ignore
			else
				error("Unknown TABLE ELEMENT #{node.name}")
			end
		elsif node.text?
			if !node.content.strip.empty? then
				error("Unknown TABLE NON EMPTY TEXT: #{node.content}")
			end
		else
			error("Unknown TABLE NODE #{node}")
		end
	}
end

def parseTableBody(element)
	# scan table first, determine structure
	firstRow = getChildElement(element,0)
#	puts "DDDDD firstRow = #{firstRow.name}"
	if firstRow.element?
		case firstRow.name
		when "tr"
			firstRowColumn = getChildElement(firstRow,0)
			if firstRowColumn.name == "th"
				hasHeaderRow = true
			end
		else
			error("TABLE wrong first row: #{fistRow}")
		end
		tableWidth = countElements(firstRow)
	end
	secondRow = getChildElement(element,1)
#	puts "DDDDD secondRow = #{secondRow.name}"
	if secondRow != nil && secondRow.element?
		case secondRow.name
		when "tr"
			secondRowColumn = getChildElement(secondRow,0)
			if secondRowColumn.name == "th"
				hasHeaderColumn = true
			end
		else
			error("TABLE wrong first row: #{fistRow}")
		end
	end

#	puts "DDDDD hasHeaderRow=#{hasHeaderRow} hasHeaderColumn=#{hasHeaderColumn} tableWidth=#{tableWidth}"

    $outFile.write('[%autowidth')
	if hasHeaderColumn
		$outFile.write(',cols="h')
		for i in 2..tableWidth
			$outFile.write(',1')
		end
		$outFile.write('"')
	end
	$outFile.write(']'+"\n")

	isHeader=hasHeaderRow
	$outFile.write("|===\n")
	element.children.each { |node|
		if node.element?
			case node.name
			when "tr"
				parseTableRow(node,isHeader)
				isHeader=false
			else
				error("Unknown TABLE BODY ELEMENT #{node.name}")
			end
		elsif node.text?
			if !node.content.strip.empty? then
				error("Unknown TABLE BODY NON EMPTY TEXT: #{node.content}")
			end
		else
			error("Unknown TABLE BODY NODE #{node}")
		end
	}
	$outFile.write("|===\n\n")
end


def parseTableWithTHead(element)

	headerRow = nil
	element.children.each { |node|
		if node.element?
			case node.name
			when "thead"
				firstRow = getChildElement(node,0)		
				if firstRow.element?
					case firstRow.name
					when "tr"
						headerRow = firstRow
						tableWidth = countElements(firstRow)
					end
				
				else
					error("TABLE wrong first row: #{fistRow}")
				end
			when "tbody"
				firstBodyRow = getChildElement(node,0)
				if firstBodyRow != nil && firstBodyRow.element?
					case firstBodyRow.name
						when "tr"
							firstBodyColumn = getChildElement(firstBodyRow,0)
							if firstBodyColumn.name == "th"
								hasHeaderColumn = true
							end
						else
							error("TABLE wrong first body row: #{fistRow}")
						end
					end
				$outFile.write("\n\n[%autowidth")
				if hasHeaderColumn
					$outFile.write(',cols="h')
					for i in 2..tableWidth
						$outFile.write(',1')
					end
					$outFile.write('"')
				end
				$outFile.write(']'+"\n")
				
				$outFile.write("|===\n")
				parseTableRow(headerRow,true)
				node.children.each { |subnode|
					if subnode.element?
						case subnode.name
						when "tr"
							parseTableRow(subnode,false)
						else
							error("Unknown TABLE BODY ELEMENT #{subnode.name}")
						end
					elsif subnode.text?
						if !subnode.content.strip.empty? then
							error("Unknown TABLE BODY NON EMPTY TEXT: #{subnode.content}")
						end
					else
						error("Unknown TABLE BODY NODE #{node}")
					end
				}
				$outFile.write("|===\n\n")

				
			when "colgroup"
				# pretty much safe to ignore
			else
				error("Unknown TABLE ELEMENT #{node.name}")
			end
		elsif node.text?
			if !node.content.strip.empty? then
				error("Unknown TABLE NON EMPTY TEXT: #{node.content}")
			end
		else
			error("Unknown TABLE NODE #{node}")
		end
	}

end


def parseTableRow(element,isHeader)
	element.children.each { |node|
		if node.element?
			case node.name
			when "th", "td"
				if node['rowspan'] && node['colspan'] && node['rowspan'].to_i > 1 && node['colspan'].to_i > 1
					$outFile.write("#{node['colspan']}.#{node['rowspan']}+")
				else
					if node['rowspan'] && node['rowspan'].to_i > 1
						$outFile.write(".#{node['rowspan']}+")
					end
					if node['colspan'] && node['colspan'].to_i > 1
						$outFile.write("#{node['colspan']}+")
					end
				end
				if isHeader
					$outFile.write("| #{node.content} ")
				else
					$outFile.write("| ")
					convertTextChildren(node, 0)
					$outFile.write("\n")
				end
			else
				error("Unknown TABLE ROW ELEMENT #{node.name}")
			end
		elsif node.text?
			if !node.content.strip.empty? then
				error("Unknown TABLE ROW NON EMPTY TEXT: #{node.content}")
			end
		else
			error("Unknown TABLE ROW NODE #{node}")
		end
	}
	$outFile.write("\n\n")
end

def parsePre(element)
	$outFile.write("\n....\n")
	convertTextChildren(element, 0)
	$outFile.write("\n....\n\n")
end

def parseBlockquote(element)
	$outFile.write("\n[quote]\n____\n")
	convertTextChildren(element, 0)
	$outFile.write("\n____\n\n")
end

def getChildElement(element,index)
	i=0
	for node in element.children
		if node.element?
			if i==index then
				return node
			end
			i = i + 1
		end
	end
	return nil
end

def countElements(element)
	count=0
	for node in element.children
		if node.element?
			count = count + 1
		end
	end
	return count
end


def parseElement(element)
	
	case element.name
	when "p", "div"
		parseP(element)
	when "h1"
		parseH(element,"==")
	when "h2"
		parseH(element,"===")
	when "h3"
		parseH(element,"====")
	when "h4"
		parseH(element,"=====")
	when "h5"
		parseH(element,"======")
	when "ul"
		parseList(element, '*', 0)
	when "ol"
		parseList(element, '.', 0)
	when "table"
		parseTable(element)
	when "ac:structured-macro", "structured-macro"
		parseMacro(element)
	when "pre"
		parsePre(element)
	when "blockquote"
		parseBlockquote(element)
	when "a"
		parseA(element)
	when "br"
		$outFile.write(" +\n")
	when "link", "ac:link"
		parseLink(element)
	when "hr"
		$outFile.write("'''\n")
	when "code", "pre"
		convertQuotedNode(element,"`")

	else
		error("Unexpected element #{element.name}")
	end
end

def getWikiPage(title)
	conn = wikiConnect()

	selfLink = getWikiSelfLink(conn,title)
	
	if selfLink == nil
		return nil
	end

#	puts "** #{selfLink}"

	selfResponse = conn.get(selfLink, {expand: 'body.storage'})
	if selfResponse == nil
		error("Got nothing from #{selfLink}")
		return nil
	end
	selfJson = JSON.parse(selfResponse.body)

#	puts "====[ selfJson ]===="
#	puts JSON.pretty_generate(selfJson)
	
	if selfJson["body"] == nil
		error("No body from #{selfLink}")
		return nil
	end

	storage = selfJson["body"]["storage"]["value"]

	puts "Retrieved page #{title}"

#	puts "===="
#	puts storage

	return storage
end

def getWikiAttachment(title,filename)
	conn = wikiConnect()

	# rest/api/content/{id}/child/attachment
	selfLink = getWikiSelfLink(conn,title)

#	puts "** #{selfLink}"

	selfResponse = conn.get("#{selfLink}/child/attachment")
	selfJson = JSON.parse(selfResponse.body)

#	puts "====ATT"
#	puts JSON.pretty_generate(selfJson)

	results = selfJson["results"]

	attDesc = findAttachmentDesc(results, filename)
	
	if attDesc == nil
		error("Cannot find attachment #{filename} referenced from the page")
		return nil
	else

	#	puts "====ATTD"
	#	puts JSON.pretty_generate(attDesc)

		downloadUrl = attDesc["_links"]["download"]

	#	puts "====DL: #{downloadUrl}"

		dlResponse = conn.get(downloadUrl)

	#	puts "====DLsize: #{dlResponse.body.size}"
	
		mangledFilename = filename.gsub(/[^a-zA-Z0-9\-\_\.]/, '-')

		puts "Retrieved attachement #{filename}, #{dlResponse.body.size} bytes, storing as #{mangledFilename}"

		File.open($outputDir + "/" + mangledFilename, 'wb') { |fp| fp.write(dlResponse.body) }

	#	puts "===="
	#	puts storage
		return mangledFilename
	end
	
end

def findAttachmentDesc(results, filename)
	for result in results
		if result["type"] != "attachment"
			next
		end
		if result["title"] != filename
			next
		end
		return result
	end
	return nil
end

def wikiConnect()
	Faraday.new(url: $wikiUrl) do |faraday|
          faraday.request :url_encoded # form-encode POST params
#          faraday.response :logger                  # log requests to STDOUT
          faraday.adapter Faraday.default_adapter # make requests with Net::HTTP
          faraday.basic_auth($username, $password)
        end
end

def getWikiSelfLink(conn,title)

	searchResponse = conn.get('rest/api/content', {spaceKey: $spaceName, title: title})

#	puts searchResponse
#	puts "===="
#	puts searchResponse.body

	searchResponseJson = JSON.parse(searchResponse.body)
	searchResults = searchResponseJson['results']
	
	if searchResults == nil || searchResults.empty?
		selfLink = searchResponseJson['_links']['self']
		if selfLink == nil		
			error("Page \"#{title}\" not found")
			return nil
		end
	else

	#	puts "===="
	#	puts JSON.pretty_generate(searchResults)

		selfLink = searchResults[0]["_links"]["self"]
		
	end

#	puts "selfLink: #{selfLink}"

	return selfLink
end

def warn(message)
	STDERR.puts("WARNING: #{message}")
end

def error(message)
	STDERR.puts("ERROR: #{message}")
end

if File.exist?(ARGV[0])
	parseFile(ARGV[0])
else
	parseWiki(ARGV[0])
end


