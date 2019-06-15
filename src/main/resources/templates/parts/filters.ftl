<#macro filters path>
<form method="get" action="${path}">

<#--MONITORS-->

    <span class="font-weight-bolder" style="font-size: 0.95rem;">Monitor</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck1">
            <label class="custom-control-label" for="customCheck1">13"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck2">
            <label class="custom-control-label" for="customCheck2">14"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck3">
            <label class="custom-control-label" for="customCheck3">15,6"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck4">
            <label class="custom-control-label" for="customCheck4">17"</label>
        </div>
    </div>

    <div class="form-group">
        <span class="font-weight-bolder" style="font-size: 0.95rem;">Manufacturer</span>
        <select class="custom-select">
            <option selected disabled>Choose...</option>
            <option value="Acer">Acer</option>
            <option value="Apple">Apple</option>
            <option value="Asus">Asus</option>
            <option value="HP">HP</option>
            <option value="Lenovo">Lenovo</option>
            <option value="DELL">DELL</option>
        </select>
    </div>

    <div class="form-group">
        <span class="font-weight-bolder" style="font-size: 0.95rem;">CPU</span>
        <select class="custom-select">
            <option selected disabled>Choose...</option>
            <option value="Intel Core i3">Intel Core i3</option>
            <option value="Intel Core i5">Intel Core i5</option>
            <option value="Intel Core i7">Intel Core i7</option>
            <option value="Intel Core i9">Intel Core i9</option>
        </select>
    </div>

    <h6 class="font-weight-bolder" style="font-size: 0.95rem;">RAM</h6>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck5">
            <label class="custom-control-label" for="customCheck5">2Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck6">
            <label class="custom-control-label" for="customCheck6">4Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck7">
            <label class="custom-control-label" for="customCheck7">8Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck8">
            <label class="custom-control-label" for="customCheck8">16Gb</label>
        </div>
    </div>

<#--STORAGE TYPE-->

    <h6 class="font-weight-bolder" style="font-size: 0.95rem;">Storage Type</h6>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck9">
            <label class="custom-control-label" for="customCheck9">SSD</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck10">
            <label class="custom-control-label" for="customCheck10">HDD</label>
        </div>
    </div>

<#--Hard Drive Size-->

    <span class="font-weight-bolder" style="font-size: 0.95rem;">Hard Drive Size</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck11">
            <label class="custom-control-label" for="customCheck11">250Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck12">
            <label class="custom-control-label" for="customCheck12">500Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck13">
            <label class="custom-control-label" for="customCheck13">1Tb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck14">
            <label class="custom-control-label" for="customCheck14">2Tb</label>
        </div>
    </div>

    <#--Video Card-->

    <span class="font-weight-bolder" style="font-size: 0.95rem;">Video Card</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck15">
            <label class="custom-control-label" for="customCheck15">NVIDIA</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck16">
            <label class="custom-control-label" for="customCheck16">AMD Radeon</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="customCheck17">
            <label class="custom-control-label" for="customCheck17">Intel HD Graphics</label>
        </div>
    </div>

    <button type="submit" class="btn btn-primary mx-auto d-block">Submit</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</#macro>