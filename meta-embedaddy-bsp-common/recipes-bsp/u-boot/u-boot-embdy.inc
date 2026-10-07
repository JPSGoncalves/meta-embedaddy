require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

SRC_URI = "git://git.u-boot-project.org/u-boot/u-boot;protocol=https;branch=main"
SRC_URI:append = " file://uboot-common.cfg"
SRC_URI:append = " file://uboot.cfg"


EMBDY_UBOOT_LOCALVERSION = "-embdy"

do_compile:prepend() {
    v="${EMBDY_UBOOT_LOCALVERSION}-g$(git -C ${S} rev-parse --short=12 HEAD)"
    echo "$v" > ${B}/.scmversion
    echo "$v" > ${S}/.scmversion
}

do_deploy:append() {
    install -m 0644 ${B}/u-boot.dtb ${DEPLOYDIR}
    install -m 0644 ${B}/.config ${DEPLOYDIR}/u-boot.config
}
