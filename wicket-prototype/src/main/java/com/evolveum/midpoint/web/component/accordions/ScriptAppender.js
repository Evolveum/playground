function AppendAccordionScript(id, expanded, multipleSelect, openedPanel){
	alert("script occured with var: " + id );
	var accordion = "accordion_" +id;
	accordion=new TINY.accordion.slider(accordion);
	accordion.init("'"+id+"'","h3",multipleSelect,openedPanel,"acc-selected");

	if(expanded){
		accordion.pr(1);
	}
}
