require linux-embdy.inc

SUMMARY = "Embedaddy Mainline Linux kernel"
DESCRIPTION = "Torvalds mainline tree"

LINUX_VERSION ?= "7.3-rc1"
SRCREV ?= "cee9395acd8043be0644b25c34bfa86623f2b935"
SRCREV:use-head = "${AUTOREV}"

KERNEL_VERSION_SANITY_SKIP = "0"
KERNEL_VERSION_SANITY_SKIP:use-head = "1"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;branch=master"
