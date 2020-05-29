/*Gruppo*/
INSERT INTO `Gruppo` VALUES(`ACDC`,`ACDC`,`1975`);
INSERT INTO `Gruppo` VALUES(`PTN`,`Pinguini Tattici Nucleari`,`2012`);
INSERT INTO `Gruppo` VALUES(`LP`,`Linkin Park`,`1998`);

/*Album*/
INSERT INTO `Album` VALUES(`AFN2019`,`PTN`,`Faber Nostrum`,`2019`);
INSERT INTO `Album` VALUES(`AHT2001`,`LP`,`Hybrid THeory`,`2001`);

/*Concerti*/
INSERT INTO `Concerti` VALUES(`C1M19`,`Concertone`,`Roma` `01052019`);

/*Partecipa*/
INSERT INTO `Partecipa` VALUES(`ACDC`,`C1M19`,`01052019`);
INSERT INTO `Partecipa` VALUES(`LP`,`C1M19`,`01052019`);

/*Componenti*/
INSERT INTO `Componenti` VALUES(`CG101`,`Italia`,`30000`,`10811950`,`EGSTRUM`,`FNCANT`,`ACDC`);
INSERT INTO `Componenti` VALUES(`CG201`,`Italia`,`20000`,`11011992`,`ABSTRUM`,`RZCANT`,`PTN`);
INSERT INTO `Componenti` VALUES(`CG301`,`Italia`,`10000`,`11111976`,`CFSTRUM`,`CDCANT`,`LP`);

/*Strumentista*/
INSERT INTO `Strumentista` VALUES(`RFSTRUM`,`Facchinetti`,`Roby`);
INSERT INTO `Strumentista` VALUES(`ABSTRUM`,`Aa`,`Bb`);
INSERT INTO `Strumentista` VALUES(`CFSTRUM`,`Cc`,`Ff`);

/*Strumenti*/
INSERT INTO `Strumenti` VALUES(`TSTRUM`,`RFSTRUM`,`Tastiera`);
INSERT INTO `Strumenti` VALUES(`BTSTRUM`,`ABSTRUM`,`Batteria`);

/*Cantante*/
INSERT INTO `Cantante` VALUES(`RZCANT`,`CG101`,`Riccardo`,`Zanotti`);
INSERT INTO `Cantante` VALUES(`FNCANT`,`CG201`,`Ff`,`Nn`);
INSERT INTO `Cantante` VALUES(`CDCANT`,`CG301`,`Cc`,`Dd`);

/*Canzoni*/
INSERT INTO `Canzoni` VALUES(`C01`,`RZCANT`,`Verdura`);
INSERT INTO `Canzoni` VALUES(`C02`,`FNCANT`,`canzone1`);
INSERT INTO `Canzoni` VALUES(`C03`,`CDCANT`,`canzone2`);
