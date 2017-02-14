

# clean des image
ls | grep -P ".*-\d+x\d+\.((png)|(jpg))" | xargs -d "\n" rm
