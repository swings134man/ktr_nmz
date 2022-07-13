package com.diablo.ktr.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustMgmtDTO {

    private String custEmal;		/*고객email*/
    private String custId;			/*고객ID*/
    private String custPw;			/*고객PW*/
    private String custNm;			/*고객이름*/
    private String custHphn;		/*고객핸드폰번호*/
    private String custGen;			/*고객성별*/
    private String custAge;			/*고객나이*/
    private String custAddr;		/*고객주소*/

    private String msg;
}
