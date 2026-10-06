package pl.threadx.web.inchthread;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.threadx.application.inchthread.CalculateParamsCommand;
import pl.threadx.application.inchthread.InchThreadService;
import pl.threadx.web.inchthread.dto.InchThreadRequest;
import pl.threadx.web.inchthread.dto.InchThreadResponse;

@RestController
@RequestMapping("api/v1/inch-threads")
@RequiredArgsConstructor
public class InchThreadController {

    private final InchThreadService service;

    @PostMapping(
            value = "params-calc",
            consumes = "application/json",
            produces = "application/json"
    )
    public InchThreadResponse calculateParams(@RequestBody InchThreadRequest request) {
        var cmd = CalculateParamsCommand.builder()
                .threadSize(request.threadSize())
                .threadsPerInch(request.threadPerInch())
                .toleranceClass(request.toleranceClass())
                .build();

        var thread = service.calculateParams(cmd);
        return InchThreadResponse.fromInchThread(thread);
    }
}

