ALTER TABLE Doctors
ADD active tinyint;
UPDATE Doctors SET active = 1;