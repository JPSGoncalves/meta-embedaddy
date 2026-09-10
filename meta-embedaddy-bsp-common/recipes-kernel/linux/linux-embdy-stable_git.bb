require linux-embdy.inc

SUMMARY = "Embedaddy Upstream Stable Linux kernel"
DESCRIPTION = "GregKH stable upstream tree"

LINUX_VERSION ?= "6.18.50"
SRCREV ?= "7cfc41f8e80f11ffa8382ed1a505154ceffb79c7"

MAJOR_VER = "${@d.getVar('PV').rsplit('.', 1)[0]}"
KBRANCH = "linux-${MAJOR_VER}.y"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=${KBRANCH}"
