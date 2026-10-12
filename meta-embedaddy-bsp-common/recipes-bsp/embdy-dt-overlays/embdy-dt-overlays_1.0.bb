SUMMARY = "Embedaddy custom device tree overlays"
DESCRIPTION = "Compiles board-specific device tree overlay sources by machine"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

# Overlay sources are added per machine by BSP bbappends.
SRC_URI = ""

inherit devicetree
