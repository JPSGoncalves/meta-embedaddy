require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc


SRC_URI = "git://source.denx.de/u-boot/u-boot.git;protocol=https;branch=master"
SRC_URI:append = " file://uboot-common.cfg"
SRC_URI:append = " file://uboot.cfg"

do_deploy:append() {
    install -m 0644 ${B}/u-boot.dtb ${DEPLOYDIR}
    install -m 0644 ${B}/.config ${DEPLOYDIR}/u-boot.config
}
