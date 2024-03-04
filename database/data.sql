INSERT INTO my_blog_db.categories (created_at, updated_at, name)
values
(1, now(), now(), 'Category 1'),
(2, now(), now(), 'Category 2'),
(3, now(), now(), 'Category 3'),
(4, now(), now(), 'Category 4'),
(5, now(), now(), 'Category 5');

INSERT INTO my_blog_db.tags (id, created_at, updated_at, name)
values
(1, now(), now(), 'Tag 1'),
(2, now(), now(), 'Tag 2'),
(3, now(), now(), 'Tag 3'),
(4, now(), now(), 'Tag 4'),
(5, now(), now(), 'Tag 5');

INSERT INTO my_blog_db.roles (id, created_at, updated_at, code, name)
VALUES(1, now(), now(), 'admin', 'Quan tri vien');


INSERT INTO my_blog_db.users (id, active, created_at, updated_at, avatar, email, name, password)
VALUES(1, 1, now(), now(), 'http://localhost:8080/resources/admin/img/img.jpg', 'nhattruongnguyenag@gmail.com', 'Nguyen Nhat Truong', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG');

INSERT INTO my_blog_db.users_roles (role_id, user_id) VALUES(1, 1);

INSERT INTO my_blog_db.posts (id, created_at, updated_at, like_count,  view_count, content, description, slug, thumbnail, title)
values
(1, now(), now(), 0, 0, '<p class="description">Bộ Ngoại giao Nga cho biết tình hình ở tiền tuyến của Ukraine rất tồi tệ
        và những tuyên bố
        mới của đồng minh phương Tây không giúp ích gì.</p>
    <article class="fck_detail ">
        <p class="Normal">"Chính quyền ở Kiev đang đối mặt với tình hình thảm họa ở tiền tuyến và
            không có gì có thể
            giúp cải thiện điều đó", <em>TASS</em> hôm nay dẫn lời Maria Zakharova, người phát ngôn
            Bộ Ngoại giao Nga.
        </p>
        <p class="Normal">Bà Zakharova cho rằng Ukraine sẽ cần một số lời hùng biện mạnh mẽ để có
            thể khích lệ quân đội.
            Tuy nhiên, nhà ngoại giao Nga nói tuyên bố mới đây của Tổng thống Pháp Emmanuel Macron
            về khả năng đưa quân
            đội phương Tây tới Ukraine không có tác dụng.</p>
        <p class="Normal">"Tuyên bố của ông Macron có tác dụng gì không ư? Mọi thứ hoàn toàn ngược
            lại", bà nói.</p>
        <p class="Normal">Bà cho biết sau phát biểu của ông Macron ngày 26/2, nhiều quan chức NATO
            và lãnh đạo phương
            Tây đã lên tiếng loại trừ khả năng đưa quân tới chiến trường Ukraine.</p>
        <figure data-size="true" itemprop="associatedMedia image" itemscope="" itemtype="http://schema.org/ImageObject" class="tplCaption action_thumb_added">
            <div class="action_thumb flexbox" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1); z-index: 9; display: none;">
                <a href="javascript:;" class="share_photo" data-type="fb" data-reference-id="0">
                    <svg class="ic ic-facebook">
                        <use xlink:href="#Facebook"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="share_photo" data-type="tw" data-reference-id="0">
                    <svg class="ic ic-twitte">
                        <use xlink:href="#Twitter"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="vne_zoom" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1);">
                    <svg class="ic ic-zoom">
                        <use xlink:href="#Zoom"></use>
                    </svg>
                </a>
            </div>
            <meta itemprop="url" content="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=0&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=uViJPbrWdvnyXKFWsU5kvw">
            <meta itemprop="width" content="2400">
            <meta itemprop="height" content="1600">
            <meta itemprop="href" content="">
            <div class="fig-picture" style="padding-bottom: 66.666666666667%;position: relative;">
                <picture data-inimage="done">
                    <!--[if IE 9]>
                    <video style="display: none;"><![endif]-->
                    <source data-srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=e3MynL0CR4wV3jN5nFCBfw 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=qNGEmN4PjvsiwKzyfvrYYw 2x" srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=e3MynL0CR4wV3jN5nFCBfw 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=qNGEmN4PjvsiwKzyfvrYYw 2x">
                    <!--[if IE 9]></video><![endif]-->
                    <img itemprop="contentUrl" style="position: absolute;width:100%;left:0;" loading="lazy" intrinsicsize="680x0" alt="Người phát ngôn Bộ Ngoại giao Nga Maria Zakharova tại Moskva hồi tháng 4/2023. Ảnh: AFP" class="lazy lazied" src="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg" data-src="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg" data-ll-status="loaded" data-adbro-processed="true">
                    <div class="embed-container-ads" style="display: block; width: 100%; padding-bottom: 0px !important; margin-bottom: 0px !important; background: transparent; overflow: hidden; float: left; height: 100px; position: absolute; bottom: -1px;">
                        <div id="sis_inimage" style="position: relative; width: 100%; height: 100%; text-align: center;" data-google-query-id="CKapzOLMzoQDFSXnFgUdGIIGmQ">
                            <div id="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0__container__" style="border: 0pt none;">
                                <iframe id="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0" name="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0" title="3rd party ad content" width="1" height="1" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" aria-label="Advertisement" tabindex="0" allow="attribution-reporting" style="border: 0px; vertical-align: bottom;" data-load-complete="true" data-google-container-id="4"></iframe>
                            </div>
                        </div>
                    </div>
                </picture>
            </div>
            <figcaption itemprop="description">
                <p class="Image">Người phát ngôn Bộ Ngoại giao Nga Maria Zakharova tại Moskva hồi
                    tháng 4/2023. Ảnh:
                    <em>AFP</em>
                </p>
            </figcaption>
        </figure>
        <p class="Normal">Điện Kremlin ngày 27/2 cảnh báo nếu phương Tây điều quân tới <a href="https://vnexpress.net/chu-de/ukraine-692" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Ukraine&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Ukraine</a>, điều đó có nguy cơ gây ra đối đầu trực tiếp "không
            thể tránh khỏi" giữa
            NATO với Nga, điều mà nhiều lãnh đạo phương Tây luôn tìm cách tránh.</p>
        <p class="Normal">"Các nước NATO phải đánh giá và nhận thức rõ hậu quả của động thái như
            vậy", Dmitry Peskov,
            người phát ngôn Điện Kremlin, cho biết. "Họ cần đặt câu hỏi rằng quyết định điều quân có
            phù hợp với lợi ích
            của quốc gia và quan trọng nhất là lợi ích của người dân nước họ hay không".</p>
        <p class="Normal">Những bình luận của quan chức phương Tây và <a href="https://vnexpress.net/chu-de/nga-710" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Nga&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Nga</a> đưa ra trong bối cảnh Ukraine chứng kiến nhiều bước lùi
            trên tiền tuyến. Bộ
            Quốc phòng Nga ngày 27/2 thông báo lực lượng nước này kiểm soát thêm hai làng Severnoe
            và Petrovskoye gần
            thành phố Avdeevka, đồng thời đẩy lùi 9 đợt phản công của Ukraine tại mặt trận ở tỉnh
            Donetsk.</p>
        <p class="Normal">Nga ngày 17/2 tuyên bố kiểm soát hoàn toàn <a href="https://vnexpress.net/ly-do-quan-doi-ukraine-that-thu-o-avdeevka-4713283.html" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Avdeevka&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Avdeevka</a> sau nhiều tháng công phá thành trì ở tỉnh Donetsk.
            Lực lượng Nga sau đó
            tiếp tục tiến công các khu vực xung quanh Avdeevka, buộc Ukraine phải rút khỏi nhiều khu
            dân cư gần thành
            phố này.</p>
        <figure data-size="true" itemprop="associatedMedia image" itemscope="" itemtype="http://schema.org/ImageObject" class="tplCaption action_thumb_added">
            <div class="action_thumb flexbox" style="transform-origin: 0px 0px;opacity: 1;transform: scale(1, 1);display: none;z-index:9;">
                <a href="javascript:;" class="share_photo" data-type="fb" data-reference-id="0">
                    <svg class="ic ic-facebook">
                        <use xlink:href="#Facebook"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="share_photo" data-type="tw" data-reference-id="0">
                    <svg class="ic ic-twitte">
                        <use xlink:href="#Twitter"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="vne_zoom" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1);">
                    <svg class="ic ic-zoom">
                        <use xlink:href="#Zoom"></use>
                    </svg>
                </a>
            </div>
            <meta itemprop="url" content="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=0&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=BytmIyxCi_L3hFI7MpfFCg">
            <meta itemprop="width" content="2400">
            <meta itemprop="height" content="1612">
            <meta itemprop="href" content="">
            <div class="fig-picture" style="padding-bottom: 67.114093959732%;position: relative;">
                <picture>
                    <!--[if IE 9]>
                    <video style="display: none;"><![endif]-->
                    <source data-srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=rDE3h2g9ZFgjUd1KaF3gJA 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=UFZnaF7KjJT-Y04zWB7SMQ 2x" srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=rDE3h2g9ZFgjUd1KaF3gJA 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=UFZnaF7KjJT-Y04zWB7SMQ 2x">
                    <!--[if IE 9]></video><![endif]-->
                    <img itemprop="contentUrl" style="position: absolute;width:100%;left:0;" loading="lazy" intrinsicsize="680x0" alt="Cục diện chiến trường Ukraine. Đồ họa: WP" class="lazy lazied" src="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww" data-src="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww" data-ll-status="loaded">
                </picture>
            </div>
            <figcaption itemprop="description">
                <p class="Image">Cục diện chiến trường Ukraine. Đồ họa: <em>WP</em></p>
            </figcaption>
        </figure>
        <p class="Normal">Tổng thống <a href="https://vnexpress.net/chu-de/volodymyr-zelensky-4565" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Zelensky&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Zelensky</a> ngày 25/2 nói rằng 31.000 lính Ukraine đã
            thiệt mạng
            từ khi chiến sự
            bùng phát hai năm trước. Đây là lần đầu tiên Ukraine công bố tổn thất về lực lượng trong
            hơn một năm qua,
            sau khi cố vấn của ông Zelensky hồi cuối năm 2022 nói rằng 13.000 binh sĩ đã chết kể từ
            đầu chiến sự.</p>
        <p class="Normal">Các quan chức quốc phòng Mỹ hồi tháng 8/2023 nhận định Ukraine có khoảng
            70.000 binh sĩ thiệt
            mạng và 120.000 người bị thương. Bộ trưởng Quốc phòng Nga hồi tháng 11/2023 tuyên bố
            383.000 binh sĩ Ukraine
            đã thiệt mạng hoặc bị thương kể từ đầu xung đột.</p>
    </article>', 'Bộ Ngoại giao Nga cho biết tình hình ở tiền tuyến của Ukraine rất tồi tệ
        và những tuyên bố
        mới của đồng minh phương Tây không giúp ích gì.', 'nga-noi-ukarine-doi-mat-tham-hoa-o-tien-tuyen-1', 'https://i1-vnexpress.vnecdn.net/2024/02/25/ukraine-388-3940-1708864342.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=G4bkqDLckkXa-KBxmrcnpA', 'Nga nói Ukraine đối mặt thảm họa ở tiền tuyến'),
(2, now(), now(), 0, 0, '<p class="description">Bộ Ngoại giao Nga cho biết tình hình ở tiền tuyến của Ukraine rất tồi tệ
        và những tuyên bố
        mới của đồng minh phương Tây không giúp ích gì.</p>
    <article class="fck_detail ">
        <p class="Normal">"Chính quyền ở Kiev đang đối mặt với tình hình thảm họa ở tiền tuyến và
            không có gì có thể
            giúp cải thiện điều đó", <em>TASS</em> hôm nay dẫn lời Maria Zakharova, người phát ngôn
            Bộ Ngoại giao Nga.
        </p>
        <p class="Normal">Bà Zakharova cho rằng Ukraine sẽ cần một số lời hùng biện mạnh mẽ để có
            thể khích lệ quân đội.
            Tuy nhiên, nhà ngoại giao Nga nói tuyên bố mới đây của Tổng thống Pháp Emmanuel Macron
            về khả năng đưa quân
            đội phương Tây tới Ukraine không có tác dụng.</p>
        <p class="Normal">"Tuyên bố của ông Macron có tác dụng gì không ư? Mọi thứ hoàn toàn ngược
            lại", bà nói.</p>
        <p class="Normal">Bà cho biết sau phát biểu của ông Macron ngày 26/2, nhiều quan chức NATO
            và lãnh đạo phương
            Tây đã lên tiếng loại trừ khả năng đưa quân tới chiến trường Ukraine.</p>
        <figure data-size="true" itemprop="associatedMedia image" itemscope="" itemtype="http://schema.org/ImageObject" class="tplCaption action_thumb_added">
            <div class="action_thumb flexbox" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1); z-index: 9; display: none;">
                <a href="javascript:;" class="share_photo" data-type="fb" data-reference-id="0">
                    <svg class="ic ic-facebook">
                        <use xlink:href="#Facebook"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="share_photo" data-type="tw" data-reference-id="0">
                    <svg class="ic ic-twitte">
                        <use xlink:href="#Twitter"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="vne_zoom" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1);">
                    <svg class="ic ic-zoom">
                        <use xlink:href="#Zoom"></use>
                    </svg>
                </a>
            </div>
            <meta itemprop="url" content="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=0&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=uViJPbrWdvnyXKFWsU5kvw">
            <meta itemprop="width" content="2400">
            <meta itemprop="height" content="1600">
            <meta itemprop="href" content="">
            <div class="fig-picture" style="padding-bottom: 66.666666666667%;position: relative;">
                <picture data-inimage="done">
                    <!--[if IE 9]>
                    <video style="display: none;"><![endif]-->
                    <source data-srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=e3MynL0CR4wV3jN5nFCBfw 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=qNGEmN4PjvsiwKzyfvrYYw 2x" srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=e3MynL0CR4wV3jN5nFCBfw 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=qNGEmN4PjvsiwKzyfvrYYw 2x">
                    <!--[if IE 9]></video><![endif]-->
                    <img itemprop="contentUrl" style="position: absolute;width:100%;left:0;" loading="lazy" intrinsicsize="680x0" alt="Người phát ngôn Bộ Ngoại giao Nga Maria Zakharova tại Moskva hồi tháng 4/2023. Ảnh: AFP" class="lazy lazied" src="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg" data-src="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg" data-ll-status="loaded" data-adbro-processed="true">
                    <div class="embed-container-ads" style="display: block; width: 100%; padding-bottom: 0px !important; margin-bottom: 0px !important; background: transparent; overflow: hidden; float: left; height: 100px; position: absolute; bottom: -1px;">
                        <div id="sis_inimage" style="position: relative; width: 100%; height: 100%; text-align: center;" data-google-query-id="CKapzOLMzoQDFSXnFgUdGIIGmQ">
                            <div id="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0__container__" style="border: 0pt none;">
                                <iframe id="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0" name="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0" title="3rd party ad content" width="1" height="1" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" aria-label="Advertisement" tabindex="0" allow="attribution-reporting" style="border: 0px; vertical-align: bottom;" data-load-complete="true" data-google-container-id="4"></iframe>
                            </div>
                        </div>
                    </div>
                </picture>
            </div>
            <figcaption itemprop="description">
                <p class="Image">Người phát ngôn Bộ Ngoại giao Nga Maria Zakharova tại Moskva hồi
                    tháng 4/2023. Ảnh:
                    <em>AFP</em>
                </p>
            </figcaption>
        </figure>
        <p class="Normal">Điện Kremlin ngày 27/2 cảnh báo nếu phương Tây điều quân tới <a href="https://vnexpress.net/chu-de/ukraine-692" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Ukraine&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Ukraine</a>, điều đó có nguy cơ gây ra đối đầu trực tiếp "không
            thể tránh khỏi" giữa
            NATO với Nga, điều mà nhiều lãnh đạo phương Tây luôn tìm cách tránh.</p>
        <p class="Normal">"Các nước NATO phải đánh giá và nhận thức rõ hậu quả của động thái như
            vậy", Dmitry Peskov,
            người phát ngôn Điện Kremlin, cho biết. "Họ cần đặt câu hỏi rằng quyết định điều quân có
            phù hợp với lợi ích
            của quốc gia và quan trọng nhất là lợi ích của người dân nước họ hay không".</p>
        <p class="Normal">Những bình luận của quan chức phương Tây và <a href="https://vnexpress.net/chu-de/nga-710" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Nga&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Nga</a> đưa ra trong bối cảnh Ukraine chứng kiến nhiều bước lùi
            trên tiền tuyến. Bộ
            Quốc phòng Nga ngày 27/2 thông báo lực lượng nước này kiểm soát thêm hai làng Severnoe
            và Petrovskoye gần
            thành phố Avdeevka, đồng thời đẩy lùi 9 đợt phản công của Ukraine tại mặt trận ở tỉnh
            Donetsk.</p>
        <p class="Normal">Nga ngày 17/2 tuyên bố kiểm soát hoàn toàn <a href="https://vnexpress.net/ly-do-quan-doi-ukraine-that-thu-o-avdeevka-4713283.html" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Avdeevka&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Avdeevka</a> sau nhiều tháng công phá thành trì ở tỉnh Donetsk.
            Lực lượng Nga sau đó
            tiếp tục tiến công các khu vực xung quanh Avdeevka, buộc Ukraine phải rút khỏi nhiều khu
            dân cư gần thành
            phố này.</p>
        <figure data-size="true" itemprop="associatedMedia image" itemscope="" itemtype="http://schema.org/ImageObject" class="tplCaption action_thumb_added">
            <div class="action_thumb flexbox" style="transform-origin: 0px 0px;opacity: 1;transform: scale(1, 1);display: none;z-index:9;">
                <a href="javascript:;" class="share_photo" data-type="fb" data-reference-id="0">
                    <svg class="ic ic-facebook">
                        <use xlink:href="#Facebook"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="share_photo" data-type="tw" data-reference-id="0">
                    <svg class="ic ic-twitte">
                        <use xlink:href="#Twitter"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="vne_zoom" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1);">
                    <svg class="ic ic-zoom">
                        <use xlink:href="#Zoom"></use>
                    </svg>
                </a>
            </div>
            <meta itemprop="url" content="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=0&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=BytmIyxCi_L3hFI7MpfFCg">
            <meta itemprop="width" content="2400">
            <meta itemprop="height" content="1612">
            <meta itemprop="href" content="">
            <div class="fig-picture" style="padding-bottom: 67.114093959732%;position: relative;">
                <picture>
                    <!--[if IE 9]>
                    <video style="display: none;"><![endif]-->
                    <source data-srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=rDE3h2g9ZFgjUd1KaF3gJA 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=UFZnaF7KjJT-Y04zWB7SMQ 2x" srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=rDE3h2g9ZFgjUd1KaF3gJA 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=UFZnaF7KjJT-Y04zWB7SMQ 2x">
                    <!--[if IE 9]></video><![endif]-->
                    <img itemprop="contentUrl" style="position: absolute;width:100%;left:0;" loading="lazy" intrinsicsize="680x0" alt="Cục diện chiến trường Ukraine. Đồ họa: WP" class="lazy lazied" src="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww" data-src="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww" data-ll-status="loaded">
                </picture>
            </div>
            <figcaption itemprop="description">
                <p class="Image">Cục diện chiến trường Ukraine. Đồ họa: <em>WP</em></p>
            </figcaption>
        </figure>
        <p class="Normal">Tổng thống <a href="https://vnexpress.net/chu-de/volodymyr-zelensky-4565" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Zelensky&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Zelensky</a> ngày 25/2 nói rằng 31.000 lính Ukraine đã
            thiệt mạng
            từ khi chiến sự
            bùng phát hai năm trước. Đây là lần đầu tiên Ukraine công bố tổn thất về lực lượng trong
            hơn một năm qua,
            sau khi cố vấn của ông Zelensky hồi cuối năm 2022 nói rằng 13.000 binh sĩ đã chết kể từ
            đầu chiến sự.</p>
        <p class="Normal">Các quan chức quốc phòng Mỹ hồi tháng 8/2023 nhận định Ukraine có khoảng
            70.000 binh sĩ thiệt
            mạng và 120.000 người bị thương. Bộ trưởng Quốc phòng Nga hồi tháng 11/2023 tuyên bố
            383.000 binh sĩ Ukraine
            đã thiệt mạng hoặc bị thương kể từ đầu xung đột.</p>
    </article>', 'Bộ Ngoại giao Nga cho biết tình hình ở tiền tuyến của Ukraine rất tồi tệ
        và những tuyên bố
        mới của đồng minh phương Tây không giúp ích gì.', 'nga-noi-ukarine-doi-mat-tham-hoa-o-tien-tuyen-2', 'https://i1-vnexpress.vnecdn.net/2024/02/25/ukraine-388-3940-1708864342.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=G4bkqDLckkXa-KBxmrcnpA', 'Nga nói Ukraine đối mặt thảm họa ở tiền tuyến'),
        (3, now(), now(), 0, 0, '<p class="description">Bộ Ngoại giao Nga cho biết tình hình ở tiền tuyến của Ukraine rất tồi tệ
        và những tuyên bố
        mới của đồng minh phương Tây không giúp ích gì.</p>
    <article class="fck_detail ">
        <p class="Normal">"Chính quyền ở Kiev đang đối mặt với tình hình thảm họa ở tiền tuyến và
            không có gì có thể
            giúp cải thiện điều đó", <em>TASS</em> hôm nay dẫn lời Maria Zakharova, người phát ngôn
            Bộ Ngoại giao Nga.
        </p>
        <p class="Normal">Bà Zakharova cho rằng Ukraine sẽ cần một số lời hùng biện mạnh mẽ để có
            thể khích lệ quân đội.
            Tuy nhiên, nhà ngoại giao Nga nói tuyên bố mới đây của Tổng thống Pháp Emmanuel Macron
            về khả năng đưa quân
            đội phương Tây tới Ukraine không có tác dụng.</p>
        <p class="Normal">"Tuyên bố của ông Macron có tác dụng gì không ư? Mọi thứ hoàn toàn ngược
            lại", bà nói.</p>
        <p class="Normal">Bà cho biết sau phát biểu của ông Macron ngày 26/2, nhiều quan chức NATO
            và lãnh đạo phương
            Tây đã lên tiếng loại trừ khả năng đưa quân tới chiến trường Ukraine.</p>
        <figure data-size="true" itemprop="associatedMedia image" itemscope="" itemtype="http://schema.org/ImageObject" class="tplCaption action_thumb_added">
            <div class="action_thumb flexbox" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1); z-index: 9; display: none;">
                <a href="javascript:;" class="share_photo" data-type="fb" data-reference-id="0">
                    <svg class="ic ic-facebook">
                        <use xlink:href="#Facebook"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="share_photo" data-type="tw" data-reference-id="0">
                    <svg class="ic ic-twitte">
                        <use xlink:href="#Twitter"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="vne_zoom" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1);">
                    <svg class="ic ic-zoom">
                        <use xlink:href="#Zoom"></use>
                    </svg>
                </a>
            </div>
            <meta itemprop="url" content="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=0&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=uViJPbrWdvnyXKFWsU5kvw">
            <meta itemprop="width" content="2400">
            <meta itemprop="height" content="1600">
            <meta itemprop="href" content="">
            <div class="fig-picture" style="padding-bottom: 66.666666666667%;position: relative;">
                <picture data-inimage="done">
                    <!--[if IE 9]>
                    <video style="display: none;"><![endif]-->
                    <source data-srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=e3MynL0CR4wV3jN5nFCBfw 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=qNGEmN4PjvsiwKzyfvrYYw 2x" srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=e3MynL0CR4wV3jN5nFCBfw 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=qNGEmN4PjvsiwKzyfvrYYw 2x">
                    <!--[if IE 9]></video><![endif]-->
                    <img itemprop="contentUrl" style="position: absolute;width:100%;left:0;" loading="lazy" intrinsicsize="680x0" alt="Người phát ngôn Bộ Ngoại giao Nga Maria Zakharova tại Moskva hồi tháng 4/2023. Ảnh: AFP" class="lazy lazied" src="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg" data-src="https://i1-vnexpress.vnecdn.net/2024/02/28/afp-com-20230404-partners-068-6704-2840-1709123721.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=J-5qVN0ot7aE9GRvd1_2wg" data-ll-status="loaded" data-adbro-processed="true">
                    <div class="embed-container-ads" style="display: block; width: 100%; padding-bottom: 0px !important; margin-bottom: 0px !important; background: transparent; overflow: hidden; float: left; height: 100px; position: absolute; bottom: -1px;">
                        <div id="sis_inimage" style="position: relative; width: 100%; height: 100%; text-align: center;" data-google-query-id="CKapzOLMzoQDFSXnFgUdGIIGmQ">
                            <div id="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0__container__" style="border: 0pt none;">
                                <iframe id="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0" name="google_ads_iframe_/27973503/Vnexpress/Desktop/Inimage/Thegioi/Thegioi.detail_0" title="3rd party ad content" width="1" height="1" scrolling="no" marginwidth="0" marginheight="0" frameborder="0" aria-label="Advertisement" tabindex="0" allow="attribution-reporting" style="border: 0px; vertical-align: bottom;" data-load-complete="true" data-google-container-id="4"></iframe>
                            </div>
                        </div>
                    </div>
                </picture>
            </div>
            <figcaption itemprop="description">
                <p class="Image">Người phát ngôn Bộ Ngoại giao Nga Maria Zakharova tại Moskva hồi
                    tháng 4/2023. Ảnh:
                    <em>AFP</em>
                </p>
            </figcaption>
        </figure>
        <p class="Normal">Điện Kremlin ngày 27/2 cảnh báo nếu phương Tây điều quân tới <a href="https://vnexpress.net/chu-de/ukraine-692" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Ukraine&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Ukraine</a>, điều đó có nguy cơ gây ra đối đầu trực tiếp "không
            thể tránh khỏi" giữa
            NATO với Nga, điều mà nhiều lãnh đạo phương Tây luôn tìm cách tránh.</p>
        <p class="Normal">"Các nước NATO phải đánh giá và nhận thức rõ hậu quả của động thái như
            vậy", Dmitry Peskov,
            người phát ngôn Điện Kremlin, cho biết. "Họ cần đặt câu hỏi rằng quyết định điều quân có
            phù hợp với lợi ích
            của quốc gia và quan trọng nhất là lợi ích của người dân nước họ hay không".</p>
        <p class="Normal">Những bình luận của quan chức phương Tây và <a href="https://vnexpress.net/chu-de/nga-710" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Nga&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Nga</a> đưa ra trong bối cảnh Ukraine chứng kiến nhiều bước lùi
            trên tiền tuyến. Bộ
            Quốc phòng Nga ngày 27/2 thông báo lực lượng nước này kiểm soát thêm hai làng Severnoe
            và Petrovskoye gần
            thành phố Avdeevka, đồng thời đẩy lùi 9 đợt phản công của Ukraine tại mặt trận ở tỉnh
            Donetsk.</p>
        <p class="Normal">Nga ngày 17/2 tuyên bố kiểm soát hoàn toàn <a href="https://vnexpress.net/ly-do-quan-doi-ukraine-that-thu-o-avdeevka-4713283.html" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Avdeevka&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Avdeevka</a> sau nhiều tháng công phá thành trì ở tỉnh Donetsk.
            Lực lượng Nga sau đó
            tiếp tục tiến công các khu vực xung quanh Avdeevka, buộc Ukraine phải rút khỏi nhiều khu
            dân cư gần thành
            phố này.</p>
        <figure data-size="true" itemprop="associatedMedia image" itemscope="" itemtype="http://schema.org/ImageObject" class="tplCaption action_thumb_added">
            <div class="action_thumb flexbox" style="transform-origin: 0px 0px;opacity: 1;transform: scale(1, 1);display: none;z-index:9;">
                <a href="javascript:;" class="share_photo" data-type="fb" data-reference-id="0">
                    <svg class="ic ic-facebook">
                        <use xlink:href="#Facebook"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="share_photo" data-type="tw" data-reference-id="0">
                    <svg class="ic ic-twitte">
                        <use xlink:href="#Twitter"></use>
                    </svg>
                </a>
                <a href="javascript:;" class="vne_zoom" style="transform-origin: 0px 0px; opacity: 1; transform: scale(1, 1);">
                    <svg class="ic ic-zoom">
                        <use xlink:href="#Zoom"></use>
                    </svg>
                </a>
            </div>
            <meta itemprop="url" content="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=0&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=BytmIyxCi_L3hFI7MpfFCg">
            <meta itemprop="width" content="2400">
            <meta itemprop="height" content="1612">
            <meta itemprop="href" content="">
            <div class="fig-picture" style="padding-bottom: 67.114093959732%;position: relative;">
                <picture>
                    <!--[if IE 9]>
                    <video style="display: none;"><![endif]-->
                    <source data-srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=rDE3h2g9ZFgjUd1KaF3gJA 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=UFZnaF7KjJT-Y04zWB7SMQ 2x" srcset="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww 1x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=1020&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=rDE3h2g9ZFgjUd1KaF3gJA 1.5x, https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=2&amp;fit=crop&amp;s=UFZnaF7KjJT-Y04zWB7SMQ 2x">
                    <!--[if IE 9]></video><![endif]-->
                    <img itemprop="contentUrl" style="position: absolute;width:100%;left:0;" loading="lazy" intrinsicsize="680x0" alt="Cục diện chiến trường Ukraine. Đồ họa: WP" class="lazy lazied" src="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww" data-src="https://i1-vnexpress.vnecdn.net/2024/02/28/415861277-1329197241113402-539-7994-8118-1709123722.jpg?w=680&amp;h=0&amp;q=100&amp;dpr=1&amp;fit=crop&amp;s=WxvYNwz09-RamzQ2BDlwww" data-ll-status="loaded">
                </picture>
            </div>
            <figcaption itemprop="description">
                <p class="Image">Cục diện chiến trường Ukraine. Đồ họa: <em>WP</em></p>
            </figcaption>
        </figure>
        <p class="Normal">Tổng thống <a href="https://vnexpress.net/chu-de/volodymyr-zelensky-4565" rel="dofollow" data-itm-source="#vn_source=Detail-TheGioi-4716444&amp;vn_campaign=Box-InternalLink&amp;vn_medium=Link-Zelensky&amp;vn_term=Desktop&amp;vn_thumb=0" data-itm-added="1">Zelensky</a> ngày 25/2 nói rằng 31.000 lính Ukraine đã
            thiệt mạng
            từ khi chiến sự
            bùng phát hai năm trước. Đây là lần đầu tiên Ukraine công bố tổn thất về lực lượng trong
            hơn một năm qua,
            sau khi cố vấn của ông Zelensky hồi cuối năm 2022 nói rằng 13.000 binh sĩ đã chết kể từ
            đầu chiến sự.</p>
        <p class="Normal">Các quan chức quốc phòng Mỹ hồi tháng 8/2023 nhận định Ukraine có khoảng
            70.000 binh sĩ thiệt
            mạng và 120.000 người bị thương. Bộ trưởng Quốc phòng Nga hồi tháng 11/2023 tuyên bố
            383.000 binh sĩ Ukraine
            đã thiệt mạng hoặc bị thương kể từ đầu xung đột.</p>
    </article>', 'Bộ Ngoại giao Nga cho biết tình hình ở tiền tuyến của Ukraine rất tồi tệ
        và những tuyên bố
        mới của đồng minh phương Tây không giúp ích gì.', 'nga-noi-ukarine-doi-mat-tham-hoa-o-tien-tuyen-3', 'https://i1-vnexpress.vnecdn.net/2024/02/25/ukraine-388-3940-1708864342.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=G4bkqDLckkXa-KBxmrcnpA', 'Nga nói Ukraine đối mặt thảm họa ở tiền tuyến');
       
       
INSERT INTO my_blog_db.categories_posts (category_id, post_id)
VALUES(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2);

INSERT INTO my_blog_db.tags_posts  (tag_id, post_id)
VALUES(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2);

       
       
       

