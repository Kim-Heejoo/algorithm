package programmers;

import java.util.*;

public class Solution42888 {	//2019 KAKAO BLIND RECRUITMENT > ����ä�ù�
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	public static String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        Queue<Chat> queue = new LinkedList<>();
        
        for (int i = 0; i < record.length; i++) {
			String[] s = record[i].split(" ");
			if(s[0].equals("Enter")) {
				hm.put(s[1], s[2]);
				queue.add(new Chat(s[1], true));
			}else if(s[0].equals("Leave")) {
				queue.add(new Chat(s[1], false));
			}else {
				hm.replace(s[1], s[2]);
			}
		}
        
        String[] answer = new String[queue.size()];
        for (int i = 0; i < answer.length; i++) {
			Chat chat = queue.poll();
			if(chat.enter) {
				answer[i] = hm.get(chat.id)+"���� ���Խ��ϴ�.";
			}else {
				answer[i] = hm.get(chat.id)+"���� �������ϴ�.";
			}
		}
        
        return answer;
    }
	
	static class Chat {
		String id;
		boolean enter;
		public Chat(String id, boolean enter) {
			this.id = id;
			this.enter = enter;
		}
	}
}