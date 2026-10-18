FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:embdy-milkv-duos = " file://milkv-duos-i2c4-eeprom.dtso"

COMPATIBLE_MACHINE = "^embdy-milkv"
