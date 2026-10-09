FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Board-tailored defconfig instead of the generic riscv one. alldefconfig
# expands it: any symbol not listed takes its Kconfig default.
SRC_URI:append:embdy-milkv-duos = " file://defconfig"
KCONFIG_MODE:embdy-milkv-duos = "alldefconfig"
