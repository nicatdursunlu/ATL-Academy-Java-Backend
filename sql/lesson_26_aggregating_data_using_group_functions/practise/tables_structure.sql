create table if not exists circuits
(
    circuitId  integer not null
        constraint circuits_pk
            primary key,
    circuitRef varchar(255),
    name         varchar(255),
    location     varchar(255),
    country      varchar(255),
    lat          text,
    lng          text,
    alt          integer,
    url          varchar(255)
);

alter table circuits
    owner to postgres;

create table if not exists drivers
(
    driverId  integer not null
        constraint drivers_pk
            primary key,
    driverRef varchar(255),
    number      varchar(255),
    code        varchar(255),
    forename    varchar(255),
    surname     varchar(255),
    dob         varchar(255),
    nationality varchar(255),
    url         varchar(255)
);

alter table drivers
    owner to postgres;

create table if not exists races
(
    raceId    integer not null
        constraint races_pk
            primary key,
    year        integer,
    round       integer,
    circuitId integer
        constraint races_circuits_fk
            references circuits,
    name        varchar(255),
    date        date,
    raceTime  time,
    url         varchar(255)
);

alter table races
    owner to postgres;

create table if not exists results
(
    raceId          integer
        constraint results_races_fk
            references races,
    driverId        integer
        constraint results_drivers_fk
            references drivers,
    number            integer,
    grid              integer,
    position          integer,
    positionText    varchar(255),
    positionOrder   integer,
    points            integer,
    laps              integer,
    time              varchar(255),
    milliseconds      integer,
    fastestLap      varchar(255),
    rank              integer,
    fastestLapTime  varchar(255),
    fastestLapSpeed numeric
);

alter table results
    owner to postgres;

