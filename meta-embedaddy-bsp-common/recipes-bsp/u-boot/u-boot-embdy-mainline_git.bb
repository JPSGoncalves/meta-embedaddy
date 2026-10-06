require u-boot-embdy.inc

# v2026.10
SRCREV = "ece349ade2973e220f524ce59e59711cc919263f"
SRCREV:use-head = "${AUTOREV}"
DEPENDS += "gnutls-native"
