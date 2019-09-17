<#macro filters path>
<form method="get" action="${path}">

<#--OS__Tablets-->

    <#if classType == "tablets">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Operating System</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="os" value="iOS" class="custom-control-input" id="customCheck01"/>
            <label class="custom-control-label" for="customCheck01">iOS</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="os" value="Android" class="custom-control-input" id="customCheck02"/>
            <label class="custom-control-label" for="customCheck02">Android</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="os" value="Windows" class="custom-control-input" id="customCheck03"/>
            <label class="custom-control-label" for="customCheck03">Windows</label>
        </div>
    </div>
    </#if>

    <#--DualSIM__Phones-->

    <#if classType == "phones">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Dual SIM</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="dualSim" value="true" class="custom-control-input" id="customCheck01"/>
            <label class="custom-control-label" for="customCheck01">Yes</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="dualSim" value="false" class="custom-control-input" id="customCheck02"/>
            <label class="custom-control-label" for="customCheck02">No</label>
        </div>
    </div>
      </#if>

<#--SCREEN SIZE-->

    <#if classType == "laptops">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Screen Size</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="13" class="custom-control-input" id="customCheck1"/>
            <label class="custom-control-label" for="customCheck1">13"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="14" class="custom-control-input" id="customCheck2"/>
            <label class="custom-control-label" for="customCheck2">14"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="15" class="custom-control-input" id="customCheck3"/>
            <label class="custom-control-label" for="customCheck3">15,6"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="17" class="custom-control-input" id="customCheck4"/>
            <label class="custom-control-label" for="customCheck4">17"</label>
        </div>
    </div>
    </#if>


    <#if classType == "tablets">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Screen Size</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="7" class="custom-control-input" id="customCheck1"/>
            <label class="custom-control-label" for="customCheck1">7"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="8" class="custom-control-input" id="customCheck2"/>
            <label class="custom-control-label" for="customCheck2">8"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="9" class="custom-control-input" id="customCheck3"/>
            <label class="custom-control-label" for="customCheck3">9"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="10" class="custom-control-input" id="customCheck4"/>
            <label class="custom-control-label" for="customCheck4">10"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="12" class="custom-control-input" id="customCheck41"/>
            <label class="custom-control-label" for="customCheck41">12"</label>
        </div>
    </div>
    </#if>

    <#if classType == "phones">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Screen Size</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="4" class="custom-control-input" id="customCheck1"/>
            <label class="custom-control-label" for="customCheck1">4"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="5" class="custom-control-input" id="customCheck2"/>
            <label class="custom-control-label" for="customCheck2">5"</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="monitor" value="6" class="custom-control-input" id="customCheck3"/>
            <label class="custom-control-label" for="customCheck3">6"</label>
        </div>
    </div>
    </#if>

<#--MANUFACTURER-->

    <#if classType == "laptops">
        <div class="form-group">
            <span class="font-weight-bolder" style="font-size: 0.95rem;">Manufacturer</span>
            <select class="custom-select" name="manufacturer">
                <option selected="selected" disabled="disabled">Choose...</option>
                <option value="Acer">Acer</option>
                <option value="Apple">Apple</option>
                <option value="Asus">Asus</option>
                <option value="HP">HP</option>
                <option value="Lenovo">Lenovo</option>
                <option value="DELL">DELL</option>
            </select>
        </div>
    </#if>


    <#if classType == "tablets" || classType == "phones">
         <div class="form-group">
             <span class="font-weight-bolder" style="font-size: 0.95rem;">Manufacturer</span>
             <select class="custom-select" name="manufacturer">
                 <option selected="selected" disabled="disabled">Choose...</option>
                 <option value="Apple">Apple</option>
                 <option value="Samsung">Samsung</option>
                 <option value="Xiaomi">Asus</option>
                 <option value="Huawei">Huawei</option>
                 <option value="Lenovo">Lenovo</option>
                 <#if classType == "tablets"><option value="Microsoft">Microsoft</option></#if>
             </select>
         </div>
    </#if>

<#--CPU-->

    <#if classType == "laptops">
        <div class="form-group">
            <span class="font-weight-bolder" style="font-size: 0.95rem;">CPU</span>
            <select class="custom-select" name="cpu">
                <option selected="selected" disabled="disabled">Choose...</option>
                <option value="Intel Core i3">Intel Core i3</option>
                <option value="Intel Core i5">Intel Core i5</option>
                <option value="Intel Core i7">Intel Core i7</option>
                <option value="Intel Core i9">Intel Core i9</option>
            </select>
        </div>
    </#if>

     <#if classType == "tablets" || classType == "phones">
        <div class="form-group">
            <span class="font-weight-bolder" style="font-size: 0.95rem;">CPU</span>
            <select class="custom-select" name="cpu">
                <option selected="selected" disabled="disabled">Choose...</option>
                <option value="Apple A">Apple A</option>
                <option value="Exynos">Exynos</option>
                <option value="Qualcomm">Qualcomm</option>
                <option value="MediaTek">MediaTek</option>
                <option value="Hisilicon Kirin">Hisilicon Kirin</option>
                <option value="Huawei HiSilicon">Huawei HiSilicon</option>
                <#if classType == "tablets"><option value="Intel Atom">Intel Atom</option></#if>
                <#if classType == "tablets"><option value="Intel Core">Intel Core</option></#if>
                <option value="Rockchip">Rockchip</option>
                <option value="Allwinner">Allwinner</option>
            </select>
        </div>
    </#if>

<#--RAM-->


    <h6 class="font-weight-bolder" style="font-size: 0.95rem;">RAM</h6>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="ram" value="2" class="custom-control-input" id="customCheck5"/>
            <label class="custom-control-label" for="customCheck5">2Gb</label>
        </div>
            <#if classType == "tablets" || classType == "phones">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" name="ram" value="3" class="custom-control-input" id="customCheck51"/>
                <label class="custom-control-label" for="customCheck51">3Gb</label>
            </div>
            </#if>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="ram" value="4" class="custom-control-input" id="customCheck6"/>
            <label class="custom-control-label" for="customCheck6">4Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="ram" value="6" class="custom-control-input" id="customCheck61"/>
            <label class="custom-control-label" for="customCheck61">6Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="ram" value="8" class="custom-control-input" id="customCheck7"/>
            <label class="custom-control-label" for="customCheck7">8Gb</label>
        </div>
            <#if classType == "laptops">
            <div class="custom-control custom-checkbox">
                <input type="checkbox" name="ram" value="16" class="custom-control-input" id="customCheck8"/>
                <label class="custom-control-label" for="customCheck8">16Gb</label>
            </div>
            </#if>
    </div>


<#--STORAGE TYPE-->

    <#if classType == "laptops">
    <h6 class="font-weight-bolder" style="font-size: 0.95rem;">Storage Type</h6>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageType" value="SSD" class="custom-control-input" id="customCheck9"/>
            <label class="custom-control-label" for="customCheck9">SSD</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageType" value="HDD" class="custom-control-input" id="customCheck10"/>
            <label class="custom-control-label" for="customCheck10">HDD</label>
        </div>
    </div>
    </#if>

<#--STORAGE CAPACITY-->

    <#if classType == "laptops">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Storage Capacity</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="125" class="custom-control-input" id="customCheck101"/>
            <label class="custom-control-label" for="customCheck101">125Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="250" class="custom-control-input" id="customCheck11"/>
            <label class="custom-control-label" for="customCheck11">250Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="500" class="custom-control-input" id="customCheck12"/>
            <label class="custom-control-label" for="customCheck12">500Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="1000" class="custom-control-input" id="customCheck13"/>
            <label class="custom-control-label" for="customCheck13">1Tb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="2000" class="custom-control-input" id="customCheck14"/>
            <label class="custom-control-label" for="customCheck14">2Tb</label>
        </div>
    </div>
    </#if>

    <#if classType == "tablets" || classType == "phones">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Storage Capacity</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="8" class="custom-control-input" id="customCheck101"/>
            <label class="custom-control-label" for="customCheck101">8Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="16" class="custom-control-input" id="customCheck11"/>
            <label class="custom-control-label" for="customCheck11">16Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="32" class="custom-control-input" id="customCheck12"/>
            <label class="custom-control-label" for="customCheck12">32Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="64" class="custom-control-input" id="customCheck13"/>
            <label class="custom-control-label" for="customCheck13">64Gb</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="128" class="custom-control-input" id="customCheck131"/>
            <label class="custom-control-label" for="customCheck131">128Gb</label>
        </div>
         <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="256" class="custom-control-input" id="customCheck132"/>
            <label class="custom-control-label" for="customCheck132">256Gb</label>
        </div>
         <div class="custom-control custom-checkbox">
            <input type="checkbox" name="storageSize" value="512" class="custom-control-input" id="customCheck133"/>
            <label class="custom-control-label" for="customCheck133">512Gb</label>
        </div>
    </div>
    </#if>

<#--FLASH CARD__Tablests-->

    <#if classType == "tablets" || classType == "phones">
         <h6 class="font-weight-bolder" style="font-size: 0.95rem;">Flash Card</h6>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="flashCard" value="true" class="custom-control-input" id="customCheck9"/>
            <label class="custom-control-label" for="customCheck9">Yes</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="flashCard" value="false" class="custom-control-input" id="customCheck10"/>
            <label class="custom-control-label" for="customCheck10">No</label>
        </div>
    </div>
    </#if>

<#--VIDEO CARD-->

    <#if classType == "laptops">
    <span class="font-weight-bolder" style="font-size: 0.95rem;">Video Card</span>
    <div class="form-group">
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="videoCard" value="NVIDIA" class="custom-control-input" id="customCheck15"/>
            <label class="custom-control-label" for="customCheck15">NVIDIA</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="videoCard" value="AMD Radeon" class="custom-control-input" id="customCheck16"/>
            <label class="custom-control-label" for="customCheck16">AMD Radeon</label>
        </div>
        <div class="custom-control custom-checkbox">
            <input type="checkbox" name="videoCard" value="Intel HD Graphics" class="custom-control-input" id="customCheck17"/>
            <label class="custom-control-label" for="customCheck17">Intel HD Graphics</label>
        </div>
    </div>
    </#if>

<#--PRICE-->

    <span class="font-weight-bolder" style="font-size: 0.95rem;">Price</span>
    <div class="form-row form-group">
        <div class="col">
            <input type="number" name="price1" class="form-control" placeholder="from"/>
        </div>
        <div class="col">
            <input type="number" name="price2" class="form-control" placeholder="to"/>
        </div>
    </div>



    <button type="submit" class="btn btn-primary mx-auto d-block">Find</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

</form>
</#macro>