SECTION = "libs"
HOME_PAGE= "http://sourceware.org/dm/"
DESCRIPTION = "The Device-mapper is a new component of the linux kernel \
that supports logical volume management. It is required by LVM2 and EVMS. \
The original LVM (included in stock 2.4 kernels) does not use it."
LICENSE = "GPL"

PR = "r1"

S = "${WORKDIR}/${PN}${PV}"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "ftp://sources.redhat.com/pub/lvm2/LVM2.2.02.98.tgz"

inherit autotools 
#update-rc.d

# The install-script will fail without this.
EXTRA_OECONF="--with-user= --with-group= "

#INITSCRIPT_NAME = "devmap_mknod.sh"
#INITSCRIPT_PARAMS = "defaults"

do_install_append() {
	install -d ${D}/${libdir}/ioctl
	install -m 755 ${S}/libdm/libdevmapper* ${D}/${libdir}/
       # install -D -m 755 ${S}/scripts/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/${INITSCRIPT_NAME}
}

FILES_${PN}-dev += "${libdir}"
SRC_URI[md5sum] = "1ce5b7f9981e1d02dfd1d3857c8d9fbe"
SRC_URI[sha256sum] = "71030a58fef7e00d82ca4144334548e46aad24551a3cfbe7c3059b1bd137d864"
EXTRA_OEMAKE += "device-mapper"
