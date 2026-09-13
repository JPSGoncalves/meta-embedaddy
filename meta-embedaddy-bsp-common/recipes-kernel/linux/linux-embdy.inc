inherit kernel kernel-yocto

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append  = " file://kernel.cfg"

S = "${WORKDIR}/git"

LINUX_VERSION_EXTENSION ?= "-embdy"
PV = "${LINUX_VERSION}+git"

do_kernel_configcheck[noexec] = "1"
