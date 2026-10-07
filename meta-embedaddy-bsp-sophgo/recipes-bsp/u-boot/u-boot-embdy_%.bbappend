FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-riscv64-dts-sophgo-add-SG2000-dtsi.patch \
    file://0002-riscv64-dts-sophgo-add-initial-Milk-V-Duo-S-board-su.patch \
    file://0003-clk-sophgo-cv1800b-Add-SG2002-compatible-string.patch \
    file://0004-board-sophgo-Add-support-for-Milk-V-Duo-S.patch \
"
