public class StringManipulator {
    public String trimAndConcat(String string1, String string2) {
        String string_output = string1.trim() + string2.trim();
        return string_output;
    };

    public Integer getIndexOrNull(String str, char target) {
        Integer i = str.indexOf(target);
        if (i==-1){
            i = null;
        }
        return i;
    }
    public Integer getIndexOrNull(String str, String target) {
        Integer i = str.indexOf(target);
        if (i==-1){
            i = null;
        }
        return i;
    }
    public String concatSubstring(String string1, int i1, int i2, String string2) {
        String string_output = string1.substring(i1, i2) + string2;
        return string_output;
    }
}