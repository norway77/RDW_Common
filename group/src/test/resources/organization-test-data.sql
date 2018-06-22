insert into school_year(year) values
  (1994), (1995), (1996), (1997);

insert ignore into subject(id, code) values
  (1, 'Math'), (2, 'ELA'), (3, 'Science');

INSERT INTO import (id, status, content, contentType, digest, batch, creator, created, updated, message) VALUES
  (-1, 0, 4, 'application/xml', '1D849A91956B74350FF895F067F115E6', NULL, NULL, '2017-07-06 00:00:00.000000', '2017-07-06 23:16:45.640627', NULL);

insert into district_group (id, natural_id, name) values
  (-10, 'districtgroup1', 'districtgroup1'),
  (-20, 'districtgroup2', 'districtgroup2');

insert into district (id, natural_id, name) values
  (-10, 'district1', 'district1'),
  (-20, 'district2', 'district2'),
  (-30, 'district3', 'district3');

insert into school_group (id, natural_id, name) values
  (-10, 'schoolgroup1', 'schoolgroup1');

insert into school (id, district_group_id, district_id, school_group_id, natural_id, name, import_id, update_import_id, updated) VALUES
  (-101, -10, -10, -10, 'schoolNat1', 'school1', -1, -1, '1997-07-18 20:14:34.000000'),
  (-102, -10, -10, null, 'schoolNat2', 'school2', -1,  -1, '1997-07-18 20:14:34.000000'),
  (-201, -20, -20, null, 'schoolNat3', 'school3', -1, -1, '1997-07-18 20:14:34.000000'),
  (-301, null, -30, null, 'schoolNat4', 'school4', -1, -1, '1997-07-18 20:14:34.000000');
