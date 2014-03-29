
LIB_VERSION="sasabus-html5-lib-1.0."$(date '+%Y%m%d')".jar"

cd $(dirname "$0")
DIST_DIR=$(pwd -P)
echo $DIST_DIR

mkdir tmp

rsync -acO ../war/WEB-INF/classes/ tmp/
rsync -acO ../src/ tmp/
rsync -acO ../src-dmxmljson-gen/ tmp/

mkdir -p tmp/META-INF/resources

rsync -acO --exclude "/WEB-INF" ../war/ tmp/META-INF/resources/

cd tmp

zip -r --filesync --no-dir-entries ../$LIB_VERSION .

cd ..

rm -r tmp