cd $(dirname "$0")
find src -name '*.java' | xargs grep getLocalizedText | sed -r 's/^.*\.getLocalizedText\("([^"]+).*$/\1/' | sort | uniq
