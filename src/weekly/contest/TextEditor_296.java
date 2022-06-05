package weekly.contest;

public class TextEditor_296 {

    String cursor;
    String currText;
    public TextEditor_296() {
        cursor = "|";
        currText = "|";
    }

    public void addText(String text) {
        int index = currText.indexOf("|");
        StringBuilder sb = new StringBuilder();
        sb.append(currText, 0, index);
        sb.append(text);
        sb.append(currText.substring(index));
        currText = sb.toString();
    }

    //删除光标左边 k 个字符。返回实际删除的字符数目。
    public int deleteText(int k) {
        int index = currText.indexOf("|");
        int deletedLen = Math.min(k, index);//实际可以删除的字符数目
        String firstHalf = currText.substring(0, index - deletedLen);
        StringBuilder sb = new StringBuilder();
        sb.append(firstHalf);
        sb.append(currText.substring(index));
        currText = sb.toString();
        return deletedLen;
    }

    public String cursorLeft(int k) {
        StringBuilder sb = new StringBuilder();
        int index = currText.indexOf("|");
        int leftLen = Math.min(k, index); //实际可以左移的数目
        sb.append(currText, 0, index - leftLen);
        sb.append("|");
        sb.append(currText.substring(index - leftLen));
        int oldPos = sb.lastIndexOf("|");
        sb.replace(oldPos, oldPos+1,"");
        currText = sb.toString();
        int textLen = currText.length();
        index = sb.indexOf("|");
        return currText.substring(Math.max(0,index - Math.min(10, textLen)), index);
    }

    public String cursorRight(int k) {
        StringBuilder sb = new StringBuilder();
        int index = currText.indexOf("|");
        currText = currText.replace("|", "");
        int rightLen = Math.min(k, currText.length()- index); //实际可以you移的数目
        sb.append(currText, 0, index + rightLen);
        sb.append("|");
        sb.append(currText.substring(index + rightLen));
        currText = sb.toString();
        int textLen = currText.length();
        index = currText.indexOf("|");
        return currText.substring(Math.max(0, index - Math.min(10, textLen)), index);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */