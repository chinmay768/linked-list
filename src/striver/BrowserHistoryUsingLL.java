package striver;

class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;

    HistoryNode(String url){
        this.url = url;
        this.next = null;
        this.prev = null;
    }

    HistoryNode(String url, HistoryNode prev, HistoryNode next){
        this.url = url;
        this.prev = prev;
        this.next = next;
    }
}

public class BrowserHistoryUsingLL {

    static HistoryNode curr;

    BrowserHistoryUsingLL(String url){
        curr = new HistoryNode(url);
    }

    public String visit(String url){
        curr.next = new HistoryNode(url, curr, null);
        curr = curr.next;
        return curr.url;
    }

    public String back(int steps){
        while (steps != 0){
            if(curr.prev != null){
                curr = curr.prev;
            }else{
                break;
            }
            steps--;
        }
        return curr.url;
    }

    public String forward(int steps){
        while (steps != 0){
            if(curr.next != null){
                curr = curr.next;
            }else{
                break;
            }
            steps--;
        }
        return curr.url;
    }

    public static void main(String[] args) {
        BrowserHistoryUsingLL browserHistoryUsingLL = new BrowserHistoryUsingLL("google.com");
        System.out.println(browserHistoryUsingLL.visit("facebook.com") + " visit");
        System.out.println(browserHistoryUsingLL.visit("leetcode.com") + " visit");
        System.out.println(browserHistoryUsingLL.visit("instagram.com") + " visit");
        System.out.println(browserHistoryUsingLL.visit("youtube.com") + " visit");
        System.out.println(browserHistoryUsingLL.back(2) + " back 2");
        System.out.println(browserHistoryUsingLL.forward(2) + " forward 2");
        System.out.println(browserHistoryUsingLL.back(2) + " back 2");
        System.out.println(browserHistoryUsingLL.visit("gfg.com") + " visit");
        System.out.println(browserHistoryUsingLL.forward(2) + " forward 2");
    }
}
