package com.esprit.microservice.microserviceproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Builder
@Generated

public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Long numCourse;
	int level;
	@Enumerated(EnumType.STRING)
	TypeCourse typeCourse;
	@Enumerated(EnumType.STRING)
	Support support;
	Float price;
	int timeSlot;
	int userId;

}
