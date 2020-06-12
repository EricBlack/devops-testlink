package org.lyzd.testlink.controller;

import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import org.lyzd.testlink.common.*;
import org.lyzd.testlink.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.lyzd.testlink.exception.ResultException;
import org.lyzd.testlink.model.TestlinkModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shuchao
 * @create 2020 06 09 13:11
 * @description
 */

@RestController
@RequestMapping("/api")
@Api(tags = "1.0.0-SNAPSHOT", description = "Testlink接口管理", value = "Testlink接口管理")
@Slf4j
public class TestlinkController {
    @GetMapping("getPlan")
    @ApiOperation("查询测试计划")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "planName", value = "测试计划名称", dataType = DataType.STRING, paramType = ParamType.QUERY),
            @ApiImplicitParam(name="projectName", value = "项目产品名称", dataType = DataType.STRING, paramType = ParamType.QUERY)})
    public ApiResponse<TestPlanDTO> getPlan(String planName, String projectName){
        log.info("查询测试计划[项目产品=" + planName + " 测试计划名称=" + projectName);
        try{
            TestlinkModel model = new TestlinkModel();
            TestPlanDTO dto = model.queryPlan(planName, projectName);

            return ApiResponse.<TestPlanDTO>builder()
                    .code(200)
                    .message("查询计划成功")
                    .data(dto)
                    .build();
        }catch(ResultException e){
            log.error(e.getMessage(), e);
            ResultCode result = e.getResultCode();
            return ApiResponse.<TestPlanDTO>builder()
                    .code(result.getCode())
                    .message(result.getMessage())
                    .build();
        }catch (TestLinkAPIException e) {
            log.error(e.getMessage(), e);
            return ApiResponse.<TestPlanDTO>builder()
                    .code(ResultCode.PARAMETER_ERROR.getCode())
                    .message(e.getMessage())
                    .build();
        }
    }

    @PostMapping("updateResults")
    @ApiOperation(value = "更新测试结果")
    public ApiResponse updateResults(@RequestBody UpdateResultDTO updateResultDTO){
        log.info("更新测试用例结果： " + updateResultDTO.toString());
        try {
            TestlinkModel model = new TestlinkModel();
            model.updateResult(updateResultDTO);

            return ApiResponse.builder()
                    .code(ResultCode.SUCCESS.getCode())
                    .message(ResultCode.SUCCESS.getMessage())
                    .build();

        }catch (TestLinkAPIException e){
            log.error(e.getMessage(), e);
            return ApiResponse.builder()
                    .code(ResultCode.PARAMETER_ERROR.getCode())
                    .message(e.getMessage())
                    .build();
        }
    }
}
