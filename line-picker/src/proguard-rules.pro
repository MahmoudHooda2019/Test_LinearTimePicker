# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.aemo.linepicker.LinePicker {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/aemo/linepicker/repack'
-flattenpackagehierarchy
-dontpreverify
