Issue: https://issuetracker.google.com/issues/314821730<br>
Fix: https://r8-review.googlesource.com/c/r8/+/86941<br>
Replacement Until release: https://storage.googleapis.com/r8-releases/raw/main/9e4de0aa0ee15c48115af60e9e912ee1ca644a37/r8lib.jar<br>
Usage: <pre>
buildscript {
    dependencies { classpath files('../r8lib.jar') }
}
</pre>
