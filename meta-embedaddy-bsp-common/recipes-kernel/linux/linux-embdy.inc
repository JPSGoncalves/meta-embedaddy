inherit kernel kernel-yocto

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append  = " file://kernel.cfg"

S = "${WORKDIR}/git"

LINUX_VERSION_EXTENSION ?= "-embdy"
PV = "${LINUX_VERSION}+git"

do_kernel_configcheck[noexec] = "1"

do_deploy:append() {
    # always deploy the kernel .config
    install -m 0644 ${B}/.config ${DEPLOYDIR}/config-${KERNEL_ARTIFACT_NAME}
    if [ -n "${KERNEL_ARTIFACT_LINK_NAME}" ]; then
        ln -sf config-${KERNEL_ARTIFACT_NAME} ${DEPLOYDIR}/config-${KERNEL_ARTIFACT_LINK_NAME}
    fi
}

KCONFIG_MODE:embdy-milkv-duos = "alldefconfig"
KBUILD_DEFCONFIG:embdy-milkv-duos = "defconfig"
