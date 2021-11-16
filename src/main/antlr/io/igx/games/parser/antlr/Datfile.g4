grammar Datfile;

dat: (clr
     | game)*;

clr: CLRMAMEPRO LP
     clrBody*
     RP;

clrBody:
     gameName
    | description
    | version
    | homepage

    ;



game: GAME LP
        gameBody*
        RP;

gameBody: gameName
          | year
          | serial
          | description
          | region
          | developer
          | publisher
          | rom
          | any_field
          ;

rom: ROM LP
         romBody*
        RP;
romBody:  fileName
                 | size
                 | md5
                 | crc
                 | serial
                 | sha1;
size: SIZE NUMERIC;
crc: CRC NUMERIC;
md5: MD5 NUMERIC;
sha1: SHA1 NUMERIC;
serial: SERIAL STRING;
fileName: NAME (FILENAME | STRING);
gameName: NAME STRING;
year: YEAR STRING;
developer: DEVELOPER STRING;
version: VERSION (DASHED | STRING);
description: DESCRIPTION STRING;
homepage: HOMEPAGE STRING;
region: REGION STRING;
publisher: PUBLISHER STRING;
any_field: IDENTIFIER (STRING | IDENTIFIER | NUMERIC);

//keywords
GAME: 'game';
ROM: 'rom';
NAME: 'name';
YEAR: 'year';
DEVELOPER: 'developer';
SIZE: 'size';
CRC: 'crc';
MD5: 'md5';
SHA1: 'sha1';
SERIAL: 'serial';
VERSION: 'version';
REGION: 'region';
DESCRIPTION: 'description';
HOMEPAGE: 'homepage';
PUBLISHER: 'publisher';



LP: '(';
RP: ')';
CLRMAMEPRO: 'clrmamepro';

STRING : '"' ( '\\"' | . )*? '"';
DASHED: NUMERIC'-'NUMERIC'-'NUMERIC;
WS  :   [ \t\r\n\u000C]+ -> skip;
FILENAME: (NUMBER | LETTER | '_')+'.'(LETTER | NUMBER | '_')+;
NUMERIC: NUMBER | HEX;
IDENTIFIER: (LETTER | NUMBER | '-' | '_')+;
NUMBER: DIGIT+ ([.,] DIGIT+)?;
HEX: [a-fA-F0-9]+;



fragment LETTER: [A-Za-z];
fragment DIGIT: [0-9];

