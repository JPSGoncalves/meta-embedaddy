SUMMARY = "EmbeDaddy systemd-journald configuration"
DESCRIPTION = "Drop-in making the systemd journal volatile and disabling \
syslog forwarding."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://10-embedaddy.conf"

inherit allarch

# /etc drop-ins take precedence over oe-core systemd-conf's /usr/lib ones.
do_install() {
    install -D -m 0644 ${WORKDIR}/10-embedaddy.conf \
        ${D}${sysconfdir}/systemd/journald.conf.d/10-embedaddy.conf
}

FILES:${PN} = "${sysconfdir}/systemd/journald.conf.d"
