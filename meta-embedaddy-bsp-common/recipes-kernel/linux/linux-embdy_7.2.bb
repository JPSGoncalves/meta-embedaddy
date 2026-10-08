require linux-embdy.inc

SUMMARY = "Embedaddy Upstream Linux kernel 7.2"
DESCRIPTION = "Torvalds tree pinned to the v7.2 release tag"

LINUX_VERSION = "7.2"
# v7.2 (peeled tag commit)
SRCREV = "8d3ae59288f1e7d58d76558a6ee96d533bc5019f"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;branch=master"
