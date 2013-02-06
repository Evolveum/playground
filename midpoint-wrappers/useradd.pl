#!/usr/bin/perl

# (C) 2012 Radovan Semancik, all rights reserved

use strict;
use warnings;
use 5.010;

use Getopt::Long;
Getopt::Long::Configure(qw(no_auto_abbrev no_ignore_case_always));
use Data::Dumper;

use vars qw(%opt $username %conf);

%conf = (
  prohibitedArguments => [ 'system' ],
  requiredPatterns => { 
    'base-dir' => '^/home/?$',
    'home-dir' => '^/home/',
  },
  prohibitedPatterns => {
    'comment' => 'foo',
  },
  allowedUsers => {
    names => [ 'foo' ],
    namePattern => 'oo',
    min => 1000,
    max => 30000,
  },
  prohibitedUsers => {
    names => [ 'root' ],
    namePattern => 'ba',
    max => 999,
  },
  allowedGroups => {
    namePattern => '^t',
    min => 1000,
    max => 30000,
  },
  prohibitedGroups => {
    max => 999,
  },
);

sub initialize() {

  GetOptions (\%opt,
    "base-dir|b=s",
    "home-dir|d=s",
    "comment|c=s",
    "expiredate|e=s",
    "inactive|f=s",
    "gid|g=s",
    "groups|G=s", #???
    "help|h",
    "skel|k=s",
    "create-home|m",
    "no-create-home|M",
    "user-group|U",
    "no-user-group|N",
    "password|p=s",
    "system|r",
    "shell|s=s",
    "uid|u=s",
  ) or usage();
  
  if (!@ARGV) {
    print STDERR "No username\n";
    usage();
  }
  
  if (scalar(@ARGV) > 1) {
    print STDERR "Too many usernames\n";
    usage();
  }
  
  $username = shift @ARGV;

  print "Username $username, parsed args:\n";
  print Dumper(\%opt);
  
}

sub usage() {
  print STDERR "$0 bla bla\n";
  exit(-1);
}

sub error($) {
  my ($message) = @_;
  print STDERR "$message\n";
  exit(-13); # EACCESS
}

sub checkProhibitedArguments() {
  for my $prohibutedArg (@{$conf{prohibitedArguments}}) {
    if (exists $opt{$prohibutedArg}) {
      error("Argument '$prohibutedArg' is prohibited");
    }
  }
}

sub checkRequiredPatterns() {
  foreach my $key (keys %{$conf{requiredPatterns}}) {
    my $pattern = $conf{requiredPatterns}->{$key};
    if ($opt{$key} && $pattern) {
      if ($opt{$key} !~ /$pattern/) {
        error("Value '".$opt{$key}."' of argument '$key' does not match required pattern '".$pattern."'");
      }
    }
    
  }
}

sub checkProhibitedPatterns() {
  foreach my $key (keys %{$conf{prohibitedPatterns}}) {
    my $pattern = $conf{prohibitedPatterns}->{$key};
    if ($opt{$key} && $pattern) {
      if ($opt{$key} =~ /$pattern/) {
        error("Value '".$opt{$key}."' of argument '$key' matches prohibited pattern '".$pattern."'");
      }
    }
  }
}

sub isNameIn($$) {
  my ($name, $constr) = @_;
  
  if (grep { $_ eq $name } @{$constr->{names}}) {
    return 1;
  }
  
  my $pattern = $constr->{namePattern};
  if ($pattern && $name =~ /$pattern/) {
    return 1;
  }
  
  return 0;
}

sub isIdIn($$) {
  my ($id, $constr) = @_;
  
  if (exists $constr->{min} && $id < $constr->{min}) {
    return 0;
  }

  if (exists $constr->{max} && $id > $constr->{max}) {
    return 0;
  }
  
  return 1;
}


sub checkUser() {
  if (!isNameIn($username, $conf{allowedUsers}) && isNameIn($username, $conf{prohibitedUsers})) {
    error("Username '$username' is prohibited");
  }
  my $uid = $opt{uid};
  if (defined $uid) {
    if (!isIdIn($uid, $conf{allowedUsers}) && isIdIn($uid, $conf{prohibitedUsers})) {
      error("UID '$uid' is prohibited");
    }
  }
}

sub isNumeric($) {
  my ($x) = @_;
  return $x =~ /^\d+$/;
}

sub determineGroupName($) {
  my ($gid) = @_;
  return getgrgid($gid);
}

sub determineGroupId($) {
  my ($name) = @_;
  return getgrnam($name);
}

sub checkGroup($$) {
  my ($name, $gid) = @_;
  
  if (defined $name) {
    if (!isNameIn($name, $conf{allowedGroups}) && isNameIn($name, $conf{prohibitedGroups})) {
      error("Group '$name' (gid=$gid) is prohibited");
    }
  }
  if (defined $gid) {
    if (!isIdIn($gid, $conf{allowedGroups}) && isIdIn($gid, $conf{prohibitedGroups})) {
      error("GID '$gid' (name=$name) is prohibited");
    }
  }
}

sub checkGroupArg($) {
  my ($groupArg) = @_;
  if (!defined $groupArg) {
    return;
  }
  my ($gid, $name);
  if (isNumeric($groupArg)) {
    $gid = $groupArg;
    $name = determineGroupName($gid);
  } else {
    $name = $groupArg;
    $gid = determineGroupId($name);
  }
  
  print("Group: $gid: $name\n");
 
  checkGroup($name, $gid);
}

sub checkPrimaryGroup() {
  checkGroupArg($opt{gid});
}

sub checkSecondaryGroups() {
  my $groupsArg = $opt{groups};
  for my $groupArg (split(',',$groupsArg)) {
    checkGroupArg($groupArg);
  }
}

sub checks() {

  checkProhibitedArguments();  
  checkRequiredPatterns();
  checkProhibitedPatterns();
  
  checkUser();
  checkPrimaryGroup();
  checkSecondaryGroups();
}

initialize();
checks();

print "OK\n";
print "Processed args:\n";
print Dumper(\%opt);

