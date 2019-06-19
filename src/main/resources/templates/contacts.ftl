<#import "parts/common.ftl" as c>

<@c.page>

    <div class="container">
        <div class="row">

            <div class="mx-auto my-3">
                <h4>Contacts</h4>
            </div>

            <#--<h4 class="mx-auto d-block">Contacts</h4>-->


            <table class="table">
                <thead>
                <tr class="text-primary">
                    <th scope="col">Telephone numbers</th>
                    <th scope="col">Email</th>
                    <th scope="col">Address</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>MTC (33), file :) (25), Velcom (29) 555-66-77</td>
                    <td><a href="https://mail.google.com/mail/u/1/#inbox">computershop@gmail.com</a> </td>
                    <td>РБ, Минск, пр-т Независимости 2-3, 2 этаж, павельон 4</td>
                </tr>
                </tbody>
            </table>

            <div id="map" class="mb-5">

            </div>

        </div>
    </div>

  <script>
      // Initialize and add the map
      function initMap() {
          var uluru = {lat: 53.8952497, lng: 27.5475775};
          var map = new google.maps.Map(
                  document.getElementById('map'), {zoom: 15, center: uluru});
          var marker = new google.maps.Marker({position: uluru, map: map});
      }
  </script>

    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB9F4NO2khgGWgA8NU_BD67QUUDu6G30lE&callback=initMap">
    </script>

</@c.page>