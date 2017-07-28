package net.codejava.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "bookstore")
public class Book {

	private long bookId;

	private String title, author;
	private float price;
	public Book() {
		// TODO Auto-generated constructor stub
	
	}
	@Id
	@Column(name = "book_id")
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


}
