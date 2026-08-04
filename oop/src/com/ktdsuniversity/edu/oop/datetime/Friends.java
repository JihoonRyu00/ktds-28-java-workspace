package com.ktdsuniversity.edu.oop.datetime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Friends {

	private List<Friend> friendList;

	public Friends() {
		this.friendList = new ArrayList<>();
	}

	public void addFriend(Friend friend) {
		this.friendList.add(friend);
	}

	public Friend get(int index) {
		if (index >= this.friendList.size() && index < 0) {
			return null;
		}
		return this.friendList.get(index);
	}

	/**
	 * 생일이 다가오거나, 생일이거나, 생일이 지난 친구 찾아 반환
	 * 
	 * @param days 범위
	 * @return
	 */
	public List<Friend> findFriendsBy(int days) {
		days++;
		LocalDate now = LocalDate.now();
		LocalDate daysAgo = now.plusDays(-days);
		LocalDate daysLater = now.plusDays(days);
		LocalDate thisBirthDay = null;
		List<Friend> foundFriends = new ArrayList<>();
		for (Friend f : friendList) {
			thisBirthDay = f.getBirthdate().withYear(now.getYear());
			if (thisBirthDay.isAfter(daysAgo) && thisBirthDay.isBefore(daysLater)) {
				foundFriends.add(f);
			}
		}
		return foundFriends;
	}

	@Override
	public String toString() {
		return "Friends [friendList=" + friendList.toString().replaceAll("\\[F", "\\[\nF").replaceAll(", F", ",\nF")
				.replaceAll("\\]\\]", "\\]\n\\]") + "]";
	}

}