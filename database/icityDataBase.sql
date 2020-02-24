create table administrator
(
    ID        int auto_increment
        primary key,
    account   varchar(7)  not null,
    password  varchar(16) not null,
    real_name varchar(10) null,
    constraint table_name_account_uindex
        unique (account)
);

create table cases
(
    ID             int auto_increment
        primary key,
    district       varchar(20)  null,
    country        varchar(50)  null,
    area_num       varchar(15)  null,
    population     varchar(15)  null,
    case_title     varchar(100) not null,
    content_source varchar(150) null,
    content        text         not null,
    create_time    varchar(50)  null
);

create index cases_create_time_index
    on cases (create_time);

create table news
(
    ID           int auto_increment
        primary key,
    title        varchar(100)  not null,
    news_source  varchar(50)   null,
    link         varchar(1000) null,
    update_time  varchar(12)   null,
    introduction varchar(1000) null,
    content      text          null,
    genre        varchar(25)   null,
    create_time  varchar(50)   null
);

create index news_create_time_index
    on news (create_time);


