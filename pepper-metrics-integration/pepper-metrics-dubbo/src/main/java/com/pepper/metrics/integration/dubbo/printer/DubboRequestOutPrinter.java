package com.pepper.metrics.integration.dubbo.printer;

import com.pepper.metrics.core.Stats;
import com.pepper.metrics.core.extension.SpiMeta;
import com.pepper.metrics.extension.scheduled.AbstractPerfPrinter;
import com.pepper.metrics.extension.scheduled.PerfPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author zhiminxu
 * @package com.pepper.metrics.integration.dubbo.printer
 * @create_time 2019-08-15
 */
@SpiMeta(name = "dubboRequestOutPrinter")
public class DubboRequestOutPrinter extends AbstractPerfPrinter implements PerfPrinter {
    @Override
    public List<Stats> chooseStats(Set<Stats> statsSet) {
        List<Stats> statsList = new ArrayList<>();
        for (Stats stats : statsSet) {
            if (stats.getName().equalsIgnoreCase("app.dubbo.request.out")) {
                statsList.add(stats);
            }
        }
        return statsList;
    }

    @Override
    public String setMetricsName(Stats stats, List<String> tags) {
        return tags.get(3) + "." + tags.get(1);
    }
}