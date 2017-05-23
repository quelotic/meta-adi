SRCREV := "9c0d4f5d6860da69b00ceb5b1ea519836725aafa"
KBRANCH := "xcomm_zynq"
LINUX_VERSION := "4.6"

# This version extension should match CONFIG_LOCALVERSION in defconfig
LINUX_VERSION_EXTENSION = ""
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

# Sources
SRC_URI = "git://github.com/analogdevicesinc/linux.git;protocol=https;branch=${KBRANCH}"

SRCREV_machine ?= "${SRCREV}"

require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Analog Devices Linux Kernel"

# Setup for Zynq architectures
COMPATIBLE_MACHINE_zynq = "zynq"

COMPATIBLE_MACHINE_${MACHINE} = "${MACHINE}"

# # Uncomment this to make device trees. Device trees must be placed in ${THISDIR}/device_trees 
# FILESEXTRAPATHS_append := "${THISDIR}/device_trees"
# do_configure_prepend() {
#     cp ${WORKDIR}/*.dts ${TMPDIR}/work-shared/${MACHINE}/kernel-source/arch/${ARCH}/boot/dts/.
# }
