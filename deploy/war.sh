set -x

cd $(dirname "$0")
DEPLOYDIR=$(pwd)
echo $DEPLOYDIR

rm ROOT.war

TMPWARDIR=/tmp/wardir

rm -r $TMPWARDIR

rsync -av --exclude .gitignore --exclude WEB-INF/deploy ../war/ $TMPWARDIR/
rsync -av ../../DMWeb/war/WEB-INF/classes/ $TMPWARDIR/WEB-INF/classes/
date "+%F %T" > $TMPWARDIR/timestamp.txt

cd $TMPWARDIR

zip --no-dir-entries $DEPLOYDIR/ROOT.war $(find -type f)
