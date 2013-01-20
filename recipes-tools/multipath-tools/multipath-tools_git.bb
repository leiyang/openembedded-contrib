SUMMARY = "Combined disk mulitpath device utility"
DESCRIPTION = "Tools are in charge of maintaining the disk multipath device maps and react to path and map events"
HOMEPAGE = "http://christophe.varoqui.free.fr/"
DEPENDS = "readline libaio lvm2"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=7be2873b6270e45abacc503abbe2aa3d"
S="${WORKDIR}/git"

SRC_URI = "git://git.opensvc.com/multipath-tools/.git;protocol=http"

SRCREV = "c23c0d33ed98a1dcee40115018b73cb3d4cda8d7"

inherit autotools
EXTRA_OEMAKE="LIB=${libdir} exec_prefix=${exec_prefix} libdir=${libdir}"

PACKAGES += "libmpathpersist mpathpersist kpartx libmultipath multipath multipathd"

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}     = ""

FILES_libmpathpersist = "${libdir}/libmpathpersist*"
FILES_mpathpersist = "${sbindir}/mpathpersist"
FILES_kpartx = "${sbindir}/kpartx ${base_libdir}/udev/"
FILES_libmultipath = "${libdir}/libmultipath*"
FILES_multipath = "${sbindir}/multipath ${sysconfdir}"
FILES_multipathd = "${sbindir}/multipathd ${base_libdir}"

#FILES_multipath-dbg = "${libdir}/multipath/.debug/"

RDEPENDS_${PN} += "libmpathpersist mpathpersist kpartx libmultipath multipath multipathd"

