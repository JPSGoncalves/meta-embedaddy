SUMMARY = "fw_env.config for the embdy STM32MP boards"
DESCRIPTION = "Points fw_printenv/fw_setenv at the u-boot-env GPT partition"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://fw_env.config"

S = "${WORKDIR}"

do_install() {
    install -Dm 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
}

RDEPENDS:${PN} += "u-boot-fw-utils"
PACKAGE_ARCH = "${MACHINE_ARCH}"
