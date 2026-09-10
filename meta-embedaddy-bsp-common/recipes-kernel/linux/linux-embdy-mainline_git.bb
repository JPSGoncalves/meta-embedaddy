require linux-embdy.inc

SUMMARY = "Embedaddy Mainline Linux kernel"
DESCRIPTION = "Torvalds mainline tree"

LINUX_VERSION ?= "7.2"
SRCREV ?= "8d3ae59288f1e7d58d76558a6ee96d533bc5019"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;branch=master"
