package bangtaoche.spider.beans.conf;

/**
 * @author: 李飞
 * @Time: 17-12-12.
 * @Emil: leco_li@126.com
 * @GitHub: https://github.com/LecoCode
 * @Function:
 */
public class AnalsisyConfig {

    private String hand_list_page_message_name;
    private String send_list_result_message_name;
    private String hand_detailed_page_message_name;
    private String send_detailed_result_message_name;


    public String getHand_list_page_message_name() {
        return hand_list_page_message_name;
    }

    public void setHand_list_page_message_name(String hand_list_page_message_name) {
        this.hand_list_page_message_name = hand_list_page_message_name;
    }

    public String getSend_list_result_message_name() {
        return send_list_result_message_name;
    }

    public void setSend_list_result_message_name(String send_list_result_message_name) {
        this.send_list_result_message_name = send_list_result_message_name;
    }

    public String getHand_detailed_page_message_name() {
        return hand_detailed_page_message_name;
    }

    public void setHand_detailed_page_message_name(String hand_detailed_page_message_name) {
        this.hand_detailed_page_message_name = hand_detailed_page_message_name;
    }

    public String getSend_detailed_result_message_name() {
        return send_detailed_result_message_name;
    }

    public void setSend_detailed_result_message_name(String send_detailed_result_message_name) {
        this.send_detailed_result_message_name = send_detailed_result_message_name;
    }
}
