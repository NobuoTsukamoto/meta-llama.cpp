SUMMARY = "llama.cpp recipe"
HOMEPAGE = "https://github.com/ggml-org/llama.cpp"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1539dadbedb60aa18519febfeab70632"

# Compute branch info from ${PV} as Base PV...
BPV = "${@'.'.join(d.getVar('PV').split('.')[0:2])}"
DPV = "${@'.'.join(d.getVar('PV').split('.')[0:3])}"

SRCREV = "360d6533db39e11577afe9b0aece20c6b5ddaf1f"

SRC_URI = " \
    git://github.com/ggml-org/llama.cpp.git;branch=master;protocol=https \
"

DEPENDS += "\
    curl \
"

inherit cmake

FILES:${PN} += " \
    ${libdir}/libggml-base.so \
    ${libdir}/libggml-cpu.so \
    ${libdir}/libggml.so \
    ${libdir}/libmtmd.so \
    ${libdir}/libllama.so \
    ${libdir}/libggml-cpu.so \
"

FILES:${PN}-dev = " \
    ${includedir}/*.h \
    ${libdir}/cmake/ggml/*.cmake \
    ${libdir}/cmake/llama/*.cmake \
    ${libdir}/pkgconfig/*.pc \
    ${libdir}/*.so \
"

INSANE_SKIP:${PN} += "buildpaths already-stripped dev-deps"
INSANE_SKIP:${PN}-dev += "dev-elf"