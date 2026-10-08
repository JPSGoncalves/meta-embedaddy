FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Milk-V Duo S device tree, merged upstream in v7.3-rc1. Drop with the 7.2 recipe.
SRC_URI:append:embdy-milkv-duos = " \
    file://0001-riscv64-dts-sophgo-add-SG2000-dtsi.patch \
    file://0002-riscv64-dts-sophgo-add-initial-Milk-V-Duo-S-board-su.patch \
"
