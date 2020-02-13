/*
Create countries table with properly capitalized French and English
names for each country. When possible, names are usual names (e.g. North Korea) 
instead of official names (e.g. KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF) to make
user selection easier.

Using the 2014-06-29 version of the list at
https://www.iso.org/obp/ui/#search

By Pierre-Luc Soucy <www.plsoucy.com>
Free to reproduce.
*/
INSERT
	INTO
	countries(code,
	name_en,
	name_fr)
VALUES ('AD',
'Andorra',
'Andorre'),
('AE',
'United Arab Emirates',
'Émirats arabes unis'),
('AF',
'Afghanistan',
'Afghanistan'),
('AG',
'Antigua and Barbuda',
'Antigua-et-Barbuda'),
('AI',
'Anguilla',
'Anguilla'),
('AL',
'Albania',
'Albanie'),
('AM',
'Armenia',
'Arménie'),
('AO',
'Angola',
'Angola'),
('AQ',
'Antarctica',
'Antarctique'),
('AR',
'Argentina',
'Argentine'),
('AS',
'American Samoa',
'Samoa américaine'),
('AT',
'Austria',
'Autriche'),
('AU',
'Australia',
'Australie'),
('AW',
'Aruba',
'Aruba'),
('AX',
'Åland Islands',
'Îles d''Åland'),
(' AZ',
' Azerbaijan',
' Azerbaïdjan'),
(' BA',
' Bosnia
AND Herzegovina',
' Bosnie-Herzégovine'),
(' BB',
' Barbados',
' Barbade'),
(' BD',
' Bangladesh',
' Bangladesh'),
(' BE',
' Belgium',
' Belgique'),
(' BF',
' Burkina Faso',
' Burkina Faso'),
(' BG',
' Bulgaria',
' Bulgarie'),
(' BH',
' Bahrain',
' Bahreïn'),
(' BI',
' Burundi',
' Burundi'),
(' BJ',
' Benin',
' Bénin'),
(' BL',
' Saint Barthélemy',
' Saint-Barthélemy'),
(' BM',
' Bermuda',
' Bermudes'),
(' BN',
' Brunei Darussalam',
' Brunei Darussalam'),
(' BO',
' Bolivia',
' Bolivie'),
(' BQ',
' Caribbean Netherlands ',
' Pays-Bas caribéens'),
(' BR',
' Brazil',
' Brésil'),
(' BS',
' Bahamas',
' Bahamas'),
(' BT',
' Bhutan',
' Bhoutan'),
(' BV',
' Bouvet Island',
' Île Bouvet'),
(' BW',
' Botswana',
' Botswana'),
(' BY ',
' Belarus',
' Bélarus'),
(' BZ',
' Belize',
' Belize'),
(' CA',
' Canada',
' Canada'),
(' CC',
' Cocos (Keeling) Islands',
' Îles Cocos (Keeling)'),
(' CD',
' Congo,
Democratic Republic OF ',
' Congo,
République démocratique du'),
(' CF',
' Central African Republic',
' République centrafricaine'),
(' CG',
' Congo',
' Congo'),
(' CH',
' Switzerland',
' Suisse'),
(' CI',
' Côte d''Ivoire',
'Côte d''Ivoire'),
(' CK',
' Cook Islands',
' Îles Cook'),
(' CL',
' Chile',
' Chili'),
(' CM',
' Cameroon',
' Cameroun'),
(' CN',
' China',
' Chine'),
(' CO',
' Colombia',
' Colombie'),
(' CR',
' Costa Rica',
' Costa Rica'),
(' CU',
' Cuba',
' Cuba'),
(' CV',
' Cape Verde',
' Cap-Vert'),
(' CW',
' Curaçao',
' Curaçao'),
(' CX',
' Christmas Island',
' Île Christmas'),
(' CY',
' Cyprus',
' Chypre'),
(' CZ',
' Czech Republic',
' République tchèque'),
(' DE',
' Germany',
' Allemagne'),
(' DJ',
' Djibouti',
' Djibouti'),
(' DK',
' Denmark',
' Danemark'),
(' DM',
' Dominica',
' Dominique'),
(' DO',
' Dominican Republic',
' République dominicaine'),
(' DZ',
' Algeria',
' Algérie'),
(' EC',
' Ecuador',
' Équateur'),
(' EE',
' Estonia',
' Estonie'),
(' EG',
' Egypt',
' Égypte'),
(' EH',
' Western Sahara',
' Sahara Occidental'),
(' ER',
' Eritrea',
' Érythrée'),
(' ES',
' Spain',
' Espagne'),
(' ET',
' Ethiopia',
' Éthiopie'),
(' FI',
' Finland',
' Finlande'),
(' FJ',
' Fiji',
' Fidji'),
(' FK',
' Falkland Islands',
' Îles Malouines'),
(' FM',
' Micronesia,
Federated States OF ',
' Micronésie,
États fédérés de'),
(' FO',
' Faroe Islands',
' Îles Féroé'),
(' FR',
' France',
' France'),
(' GA',
' Gabon',
' Gabon'),
(' GB',
' United Kingdom',
' Royaume-Uni'),
(' GD',
' Grenada',
' Grenade'),
(' GE',
' Georgia',
' Géorgie'),
(' GF',
' French Guiana',
' Guyane française'),
(' GG',
' Guernsey',
' Guernesey'),
(' GH',
' Ghana',
' Ghana'),
(' GI',
' Gibraltar',
' Gibraltar'),
(' GL',
' Greenland',
' Groenland'),
(' GM',
' Gambia',
' Gambie'),
(' GN',
' Guinea',
' Guinée'),
(' GP',
' Guadeloupe',
' Guadeloupe'),
(' GQ',
' Equatorial Guinea',
' Guinée équatoriale'),
(' GR',
' Greece',
' Grèce'),
(' GS',
' South Georgia
AND the South Sandwich Islands',
' Géorgie du Sud et les îles Sandwich du Sud'),
(' GT',
' Guatemala',
' Guatemala'),
(' GU',
' Guam',
' Guam'),
(' GW',
' Guinea-Bissau',
' Guinée-Bissau'),
(' GY',
' Guyana',
' Guyana'),
(' HK',
' Hong Kong',
' Hong Kong'),
(' HM',
' Heard
AND McDonald Islands',
' Îles Heard et McDonald'),
(' HN',
' Honduras',
' Honduras'),
(' HR',
' Croatia',
' Croatie'),
(' HT',
' Haiti',
' Haïti'),
(' HU',
' Hungary',
' Hongrie'),
(' ID',
' Indonesia',
' Indonésie'),
(' IE',
' Ireland',
' Irlande'),
(' IL',
' Israel',
' Israël'),
(' IM',
' Isle OF Man',
' Île de Man'),
(' IN ',
' India',
' Inde'),
(' IO',
' British Indian Ocean Territory',
' Territoire britannique de l''océan Indien'),
('IQ',
'Iraq',
'Irak'),
('IR',
'Iran',
'Iran'),
('IS',
'Iceland',
'Islande'),
('IT',
'Italy',
'Italie'),
('JE',
'Jersey',
'Jersey'),
('JM',
'Jamaica',
'Jamaïque'),
('JO',
'Jordan',
'Jordanie'),
('JP',
'Japan',
'Japon'),
('KE',
'Kenya',
'Kenya'),
('KG',
'Kyrgyzstan',
'Kirghizistan'),
('KH',
'Cambodia',
'Cambodge'),
('KI',
'Kiribati',
'Kiribati'),
('KM',
'Comoros',
'Comores'),
('KN',
'Saint Kitts and Nevis',
'Saint-Kitts-et-Nevis'),
('KP',
'North Korea',
'Corée du Nord'),
('KR',
'South Korea',
'Corée du Sud'),
('KW',
'Kuwait',
'Koweït'),
('KY',
'Cayman Islands',
'Îles Caïmans'),
('KZ',
'Kazakhstan',
'Kazakhstan'),
('LA',
'Lao People''s Democratic Republic',
' Laos'),
(' LB',
' Lebanon',
' Liban'),
(' LC',
' Saint Lucia',
' Sainte-Lucie'),
(' LI',
' Liechtenstein',
' Liechtenstein'),
(' LK',
' Sri Lanka',
' Sri Lanka'),
(' LR',
' Liberia',
' Libéria'),
(' LS',
' Lesotho',
' Lesotho'),
(' LT',
' Lithuania',
' Lituanie'),
(' LU',
' Luxembourg',
' Luxembourg'),
(' LV',
' Latvia',
' Lettonie'),
(' LY',
' Libya',
' Libye'),
(' MA',
' Morocco',
' Maroc'),
(' MC',
' Monaco',
' Monaco'),
(' MD',
' Moldova',
' Moldavie'),
(' ME',
' Montenegro',
' Monténégro'),
(' MF',
' Saint-Martin (France)',
' Saint-Martin (France)'),
(' MG',
' Madagascar',
' Madagascar'),
(' MH',
' Marshall Islands',
' Îles Marshall'),
(' MK',
' Macedonia',
' Macédoine'),
(' ML',
' Mali',
' Mali'),
(' MM',
' Myanmar',
' Myanmar'),
(' MN',
' Mongolia',
' Mongolie'),
(' MO',
' Macau',
' Macao'),
(' MP',
' Northern Mariana Islands',
' Mariannes du Nord'),
(' MQ',
' Martinique',
' Martinique'),
(' MR',
' Mauritania',
' Mauritanie'),
(' MS',
' Montserrat',
' Montserrat'),
(' MT',
' Malta',
' Malte'),
(' MU',
' Mauritius',
' Maurice'),
(' MV',
' Maldives',
' Maldives'),
(' MW',
' Malawi',
' Malawi'),
(' MX',
' Mexico',
' Mexique'),
(' MY',
' Malaysia',
' Malaisie'),
(' MZ',
' Mozambique',
' Mozambique'),
(' NA',
' Namibia',
' Namibie'),
(' NC',
' NEW Caledonia',
' Nouvelle-Calédonie'),
(' NE',
' Niger',
' Niger'),
(' NF',
' Norfolk Island',
' Île Norfolk'),
(' NG',
' Nigeria',
' Nigeria'),
(' NI',
' Nicaragua',
' Nicaragua'),
(' NL',
' The Netherlands',
' Pays-Bas'),
(' NO ',
' Norway',
' Norvège'),
(' NP',
' Nepal',
' Népal'),
(' NR',
' Nauru',
' Nauru'),
(' NU',
' Niue',
' Niue'),
(' NZ',
' NEW Zealand',
' Nouvelle-Zélande'),
(' OM',
' Oman',
' Oman'),
(' PA',
' Panama',
' Panama'),
(' PE',
' Peru',
' Pérou'),
(' PF',
' French Polynesia',
' Polynésie française'),
(' PG',
' Papua NEW Guinea',
' Papouasie-Nouvelle-Guinée'),
(' PH',
' Philippines',
' Philippines'),
(' PK',
' Pakistan',
' Pakistan'),
(' PL',
' Poland',
' Pologne'),
(' PM',
' St. Pierre
AND Miquelon',
' Saint-Pierre-et-Miquelon'),
(' PN',
' Pitcairn',
' Pitcairn'),
(' PR',
' Puerto Rico',
' Puerto Rico'),
(' PS',
' Palestine,
State OF ',
' Palestine'),
(' PT',
' Portugal',
' Portugal'),
(' PW',
' Palau',
' Palau'),
(' PY',
' Paraguay',
' Paraguay'),
(' QA',
' Qatar',
' Qatar'),
(' RE',
' Réunion',
' Réunion'),
(' RO',
' Romania',
' Roumanie'),
(' RS',
' Serbia',
' Serbie'),
(' RU',
' Russian Federation',
' Russie'),
(' RW',
' Rwanda',
' Rwanda'),
(' SA',
' Saudi Arabia',
' Arabie saoudite'),
(' SB',
' Solomon Islands',
' Îles Salomon'),
(' SC',
' Seychelles',
' Seychelles'),
(' SD',
' Sudan',
' Soudan'),
(' SE',
' Sweden',
' Suède'),
(' SG',
' Singapore',
' Singapour'),
(' SH',
' Saint Helena',
' Sainte-Hélène'),
(' SI',
' Slovenia',
' Slovénie'),
(' SJ',
' Svalbard
AND Jan Mayen Islands',
' Svalbard et île de Jan Mayen'),
(' SK',
' Slovakia',
' Slovaquie'),
(' SL',
' Sierra Leone',
' Sierra Leone'),
(' SM',
' San Marino',
' Saint-Marin'),
(' SN',
' Senegal',
' Sénégal'),
(' SO',
' Somalia',
' Somalie'),
(' SR',
' Suriname',
' Suriname'),
(' SS',
' South Sudan',
' Soudan du Sud'),
(' ST',
' Sao Tome
AND Principe',
' Sao Tomé-et-Principe'),
(' SV',
' El Salvador',
' El Salvador'),
(' SX',
' Sint Maarten (Dutch part)',
' Saint-Martin (Pays-Bas)'),
(' SY',
' Syria',
' Syrie'),
(' SZ',
' Swaziland',
' Swaziland'),
(' TC',
' Turks
AND Caicos Islands',
' Îles Turks et Caicos'),
(' TD',
' Chad',
' Tchad'),
(' TF',
' French Southern Territories',
' Terres australes françaises'),
(' TG',
' Togo',
' Togo'),
(' TH',
' Thailand',
' Thaïlande'),
(' TJ',
' Tajikistan',
' Tadjikistan'),
(' TK',
' Tokelau',
' Tokelau'),
(' TL',
' Timor-Leste',
' Timor-Leste'),
(' TM',
' Turkmenistan',
' Turkménistan'),
(' TN',
' Tunisia',
' Tunisie'),
(' TO ',
' Tonga',
' Tonga'),
(' TR',
' Turkey',
' Turquie'),
(' TT',
' Trinidad
AND Tobago',
' Trinité-et-Tobago'),
(' TV',
' Tuvalu',
' Tuvalu'),
(' TW',
' Taiwan',
' Taïwan'),
(' TZ',
' Tanzania',
' Tanzanie'),
(' UA',
' Ukraine',
' Ukraine'),
(' UG',
' Uganda',
' Ouganda'),
(' UM',
' United States Minor Outlying Islands',
' Îles mineures éloignées des États-Unis'),
(' US',
' United States',
' États-Unis'),
(' UY',
' Uruguay',
' Uruguay'),
(' UZ',
' Uzbekistan',
' Ouzbékistan'),
(' VA',
' Vatican',
' Vatican'),
(' VC',
' Saint Vincent
AND the Grenadines',
' Saint-Vincent-et-les-Grenadines'),
(' VE',
' Venezuela',
' Venezuela'),
(' VG',
' Virgin Islands (British)',
' Îles Vierges britanniques'),
(' VI',
' Virgin Islands (U.S.)',
' Îles Vierges américaines'),
(' VN',
' Vietnam',
' Vietnam'),
(' VU',
' Vanuatu',
' Vanuatu'),
(' WF',
' Wallis
AND Futuna Islands',
' Îles Wallis-et-Futuna'),
(' WS',
' Samoa',
' Samoa'),
(' YE',
' Yemen',
' Yémen'),
(' YT',
' Mayotte',
' Mayotte'),
(' ZA',
' South Africa',
' Afrique du Sud'),
(' ZM',
' Zambia',
' Zambie'),
(' ZW',
' Zimbabwe',
' Zimbabwe');

COMMIT;
