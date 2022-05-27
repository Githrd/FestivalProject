/**
 * Ajax 통신을 이용한 공공데이터 작업 후
 * 뷰에 심어주고 컨트롤러에 보내주는 작업
 *
 * @author 조희덕
 * @since  2022.05.24
*/
$(document).ready(function () {
    $('#getlist').click(function (){
        $.ajax({
            post: 'get',
            url: 'http://api.data.go.kr/openapi/tn_pubr_public_cltur_fstvl_api',
            data: {
            serviceKey : 'bemqdwUBaPkICD7vYqJkeQr3XdgqI93nL9eH2nwUdCaJLsbCtU0iLozvRnkzNxSEQI7qWt2kFm++xbKo80SRMQ==',
                pageNo: '1',
                numOfRows: '2000',
                type: 'json'
            },
            success: function(data){
                var sdata = JSON.stringify(data);
                var res = JSON.parse(sdata);
                var list = [];
                for (var i = 0; i < res.response.body.items.length; i++) {
                    var str = res.response.body.items[i];
                    list +=  str.fstvlNm +'@'+ str.opar +'@'+ str.fstvlStartDate +'@'+str.fstvlEndDate+'@'+ str.fstvlCo +'@'+ str.mnnst +'@'
                        + str.auspcInstt +'@'+ str.phoneNumber +'@'+ str.homepageUrl +'@'+ str.rdnmadr +'@'+ str.latitude +'@'+ str.longitude
                        + '#';

                    $("thead").append(
                        "<tr>" +
                            "<th class=\"w3-col s1 w3-border th1\">" + str.fstvlNm + "</th>" +
                            "<th class=\"w3-col s1 w3-border th2\">" + str.opar + "</th>" +
                            "<th class=\"w3-col s1 w3-border th3\">" + str.fstvlStartDate + "</th>" +
                            "<th class=\"w3-col s1 w3-border th4\">" + str.fstvlEndDate + "</th>" +
                            "<th class=\"w3-col s1 w3-border th5\">" + str.fstvlCo + "</th>" +
                            "<th class=\"w3-col s1 w3-border th6\">" + str.mnnst + "</th>" +
                            "<th class=\"w3-col s1 w3-border th7\">" + str.auspcInstt + "</th>" +
                            "<th class=\"w3-col s1 w3-border th8\">" + str.phoneNumber + "</th>" +
                            "<th class=\"w3-col s1 w3-border th9\">" + str.homepageUrl + "</th>" +
                            "<th class=\"w3-col s1 w3-border th10\">" + str.rdnmadr + "</th>" +
                            "<th class=\"w3-col s1 w3-border th11\">" + str.latitude + "</th>" +
                            "<th class=\"w3-col s1 w3-border th12\">" + str.longitude + "</th>" +
                        "</tr>")
                }
                $('#list').val(list);
            }
        })
    });
    $('#postlist').click(function () {
        $('#frm').submit();

    });

})

