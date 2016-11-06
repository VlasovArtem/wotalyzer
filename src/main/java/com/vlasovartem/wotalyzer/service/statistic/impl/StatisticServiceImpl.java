package com.vlasovartem.wotalyzer.service.statistic.impl;

import com.vlasovartem.wotalyzer.entity.statistic.Statistic;
import com.vlasovartem.wotalyzer.entity.statistic.TankStatistic;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.Vehicles;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.components.provision.ammo.Ammo;
import com.vlasovartem.wotalyzer.repository.statistic.VehicleModuleInfoRepository;
import com.vlasovartem.wotalyzer.service.statistic.StatisticService;
import com.vlasovartem.wotalyzer.service.wot.api.tankopedia.VehicleService;
import com.vlasovartem.wotalyzer.service.wot.api.tankopedia.VehiclesService;
import com.vlasovartem.wotalyzer.utils.TankUtils;
import com.vlasovartem.wotalyzer.utils.enums.VehicleType;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia.VehicleProfileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.*;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.entity.statistic.Statistic.RangeType.*;
import static com.vlasovartem.wotalyzer.entity.statistic.Statistic.Type.*;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final static Logger LOGGER = LogManager.getLogger(StatisticServiceImpl.class);
    private TankUtils tankUtils;
    private VehicleProfileUtils vehicleProfileUtils;
    private VehiclesService vehiclesService;
    private VehicleService vehicleService;
    private List<String> bestVehicleDynamicStatisticFields;
    private List<String> bestVehiclePenetrationStatisticFields;
    private VehicleModuleInfoRepository vehicleModuleInfoRepository;

    @Autowired
    public StatisticServiceImpl(TankUtils tankUtils, VehicleProfileUtils vehicleProfileUtils, VehiclesService vehiclesService, VehicleService vehicleService, VehicleModuleInfoRepository vehicleModuleInfoRepository) {
        this.tankUtils = tankUtils;
        this.vehicleProfileUtils = vehicleProfileUtils;
        this.vehiclesService = vehiclesService;
        this.vehicleService = vehicleService;
        this.vehicleModuleInfoRepository = vehicleModuleInfoRepository;
        bestVehicleDynamicStatisticFields = Arrays.asList("tank_id", "modules_tree", "is_premium");
        bestVehiclePenetrationStatisticFields = Arrays.asList("tank_id", "is_premium");
    }

    @Override
    public Statistic<Double> bestVehicleDynamic(int tier, boolean ignorePremium) {
        return collectBestVehicleDynamic(
                new Statistic<>(WT_RATIO, TIER),
                vehiclesService.findByTierAndType(tier, bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Double> bestVehicleDynamic(VehicleType type, boolean ignorePremium) {
        return collectBestVehicleDynamic(
                new Statistic<>(WT_RATIO, TYPE),
                vehiclesService.findByTierAndType(type, bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Double> bestVehicleDynamic(int tier, VehicleType type, boolean ignorePremium) {
        return collectBestVehicleDynamic(
                new Statistic<>(WT_RATIO, TIRE_AND_TYPE),
                vehiclesService.findByTierAndType(tier, type, bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Double> bestVehicleDynamic(boolean ignorePremium) {
        return collectBestVehicleDynamic(
                new Statistic<>(WT_RATIO, ALL),
                vehiclesService.findAll(bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Ammo> bestVehiclePenetration(@Null int tier, @Null VehicleType type, boolean ignorePremium) {
        return collectBestVehiclePenetration(
                new Statistic<>(PENETRATION, TIRE_AND_TYPE),
                vehiclesService.findByTierAndType(tier, type, bestVehiclePenetrationStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Ammo> bestVehiclePenetration(VehicleType type, boolean ignorePremium) {
        return collectBestVehiclePenetration(
                new Statistic<>(PENETRATION, TYPE),
                vehiclesService.findByTierAndType(type, bestVehiclePenetrationStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Ammo> bestVehiclePenetration(int tier, boolean ignorePremium) {
        return collectBestVehiclePenetration(
                new Statistic<>(PENETRATION, TIER),
                vehiclesService.findByTierAndType(tier, bestVehiclePenetrationStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Ammo> bestVehiclePenetration(boolean ignorePremium) {
        return collectBestVehiclePenetration(
                new Statistic<>(PENETRATION, ALL),
                vehiclesService.findAll(bestVehiclePenetrationStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Integer> bestVehicleViewRange(int tier, VehicleType type, boolean ignorePremium) {
        return collectBestVehicleViewRange(
                new Statistic<>(VIEW_RANGE, TIRE_AND_TYPE),
                vehiclesService.findByTierAndType(tier, type, bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Integer> bestVehicleViewRange(VehicleType type, boolean ignorePremium) {
        return collectBestVehicleViewRange(
                new Statistic<>(VIEW_RANGE, TYPE),
                vehiclesService.findByTierAndType(type, bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Integer> bestVehicleViewRange(int tier, boolean ignorePremium) {
        return collectBestVehicleViewRange(
                new Statistic<>(VIEW_RANGE, TIER),
                vehiclesService.findByTierAndType(tier, bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Integer> bestVehicleViewRange(boolean ignorePremium) {
        return collectBestVehicleViewRange(
                new Statistic<>(VIEW_RANGE, ALL),
                vehiclesService.findByTierAndType(bestVehicleDynamicStatisticFields),
                ignorePremium);
    }

    @Override
    public Statistic<Double> compareVehicleDynamic(int tier, long tankId, boolean ignorePremium) {
        List<VehicleProfile> vehicles = findSortedVehicles(
                vehiclesService.findByTierAndType(tier, bestVehicleDynamicStatisticFields),
                ignorePremium,
                Arrays.asList("engine", "weight", "tank_id"), this::vehicleDynamicComparator);
        Statistic<Double> statistic = new Statistic<>(WT_RATIO, TIER, vehicles.size());
        statistic.setBestIndicator(new TankStatistic<>(vehicles.get(0).getId(), countEngineWTRation(vehicles.get(0))));
        return null;
    }

    @Override
    public Statistic<Double> compareVehicleDynamic(VehicleType type, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Double> compareVehicleDynamic(int tier, VehicleType type, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Double> compareVehicleDynamic(long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Ammo> compareVehiclePenetration(int tier, VehicleType type, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Ammo> compareVehiclePenetration(VehicleType type, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Ammo> compareVehiclePenetration(int tier, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Ammo> compareVehiclePenetration(long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Integer> compareVehicleViewRange(int tier, VehicleType type, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Integer> compareVehicleViewRange(VehicleType type, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Integer> compareVehicleViewRange(int tier, long tankId, boolean ignorePremium) {
        return null;
    }

    @Override
    public Statistic<Integer> compareVehicleViewRange(long tankId, boolean ignorePremium) {
        return null;
    }

    /**
     * Collect VehicleStatistic of the best Weight/Ton Ration for particular list of vehicles
     *
     * @param statistic        VehicleStatistic object that should update by collected data
     * @param searchedVehicles vehicles by how should be make collecting
     * @param ignorePremium    should be premium tanks ignore during collecting.
     * @return return VehicleStatistic object with update content.
     */
    private Statistic<Double> collectBestVehicleDynamic(Statistic<Double> statistic, List<Vehicles> searchedVehicles, boolean ignorePremium) {
        if (Objects.nonNull(statistic) && Objects.nonNull(searchedVehicles)) {
            statistic.setTotalCollectedTanks(searchedVehicles.size());
            VehicleProfile bestDynamicVehicle = findSortedVehicles(
                    searchedVehicles,
                    ignorePremium,
                    Arrays.asList("engine", "weight", "tank_id"),
                    this::vehicleDynamicComparator).stream().findFirst().orElse(null);
            if (Objects.nonNull(bestDynamicVehicle) && Objects.nonNull(bestDynamicVehicle.getEngine()) && bestDynamicVehicle.getWeight() > 0) {
                double wtRatio = bestDynamicVehicle.getEngine().getPower() / (bestDynamicVehicle.getWeight() / 1000);
                statistic.setBestIndicator(new TankStatistic<>(bestDynamicVehicle.getId(), wtRatio));
                return statistic;
            }
            LOGGER.warn("VehicleUtils with best dynamic is not found. Method search inside {} vehicles", searchedVehicles.size());
            return null;
        }
        throw new RuntimeException("VehicleStatistic and searchable vehicles cannot be null");
    }

    /**
     * Collect best top gun penetration of the vehicles of original ammo (excluding explosive and high cost)
     *
     * @param statistic        statistics object
     * @param searchedVehicles collected vehicles
     * @param ignorePremium    ignore premium vehicles
     * @return Converted statistics
     */
    private Statistic<Ammo> collectBestVehiclePenetration(Statistic<Ammo> statistic, List<Vehicles> searchedVehicles, boolean ignorePremium) {
        if (Objects.nonNull(statistic) && Objects.nonNull(searchedVehicles)) {
            statistic.setTotalCollectedTanks(searchedVehicles.size());
            VehicleProfile bestPenetrationVehicle = findSortedVehicles(
                    searchedVehicles,
                    ignorePremium,
                    Arrays.asList("ammo", "tank_id"),
                    this::vehicleAmmoComparator).stream().findFirst().orElse(null);
            if (Objects.nonNull(bestPenetrationVehicle)) {
                statistic.setBestIndicator(new TankStatistic<>(bestPenetrationVehicle.getId(), findVehicleOriginalAmmo(bestPenetrationVehicle)));
                return statistic;
            }
            LOGGER.warn("VehicleUtils with best penetration is not found. Method search inside {} vehicles", searchedVehicles.size());
            return null;
        }
        throw new RuntimeException("VehicleStatistic and searchable vehicles cannot be null");
    }

    /**
     * Collect best vehicle view range
     *
     * @param statistic
     * @param searchedVehicles
     * @param ignorePremium
     * @return
     */
    private Statistic<Integer> collectBestVehicleViewRange(Statistic<Integer> statistic, List<Vehicles> searchedVehicles, boolean ignorePremium) {
        if (Objects.nonNull(statistic) && Objects.nonNull(searchedVehicles)) {
            statistic.setTotalCollectedTanks(searchedVehicles.size());
            VehicleProfile bestViewRangeVehicle = findSortedVehicles(
                    searchedVehicles,
                    ignorePremium,
                    Arrays.asList("tank_id", "turret"),
                    this::vehicleViewRangeComparator).stream().findFirst().orElse(null);
            if (Objects.nonNull(bestViewRangeVehicle)) {
                statistic.setBestIndicator(new TankStatistic<>(bestViewRangeVehicle.getId(), bestViewRangeVehicle.getTurret().getViewRange()));
                return statistic;
            }
            LOGGER.warn("VehicleUtils with best view rang is not found. Method search inside {} vehicles", searchedVehicles.size());
            return null;
        }
        throw new RuntimeException("VehicleStatistic and searchable vehicles cannot be null");
    }

    private List<VehicleProfile> findSortedVehicles(List<Vehicles> searchedVehicles, boolean ignorePremium, List<String> vehicleAPIFields, Comparator<VehicleProfile> comparator) {
        return vehicleModuleInfoRepository
                .findByTankIdIn(searchedVehicles.parallelStream()
                        .filter(vbi -> !ignorePremium || !vbi.isPremium())
                        .map(Vehicles::getId)
                        .collect(Collectors.toList()))
                .parallelStream()
                .map(moduleInfo -> Objects.isNull(moduleInfo) ? null : vehicleService.getVehicle(moduleInfo, vehicleAPIFields))
                .filter(Objects::nonNull)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    /**
     * Find vehicle ammo. excluding high explosive ammo and gold ammo.
     *
     * @param vehicle vehicle
     * @return original ammo, excluding high explosive ammo and gold ammo.
     */
    private Ammo findVehicleOriginalAmmo(VehicleProfile vehicle) {
        if (Objects.nonNull(vehicle)) {
            String explosiveAmmoTypeName = "HIGH_EXPLOSIVE";
            return Optional.ofNullable(vehicle.getAmmo())
                    .orElse(Collections.emptyList()).stream()
                    .filter(ammo -> explosiveAmmoTypeName.equals(ammo.getType()))
                    .sorted(this::ammoComparator)
                    .findFirst().get();
        }
        return null;
    }

    /**
     * Compare ammo top penetration
     *
     * @param ammo1
     * @param ammo2
     * @return
     */
    private int ammoComparator(Ammo ammo1, Ammo ammo2) {
        int ammo1MaxPenetration = ammo1.getPenetration().stream().max(Integer::compareTo).get();
        int ammo2MaxPenetration = ammo2.getPenetration().stream().max(Integer::compareTo).get();
        return (ammo1MaxPenetration < ammo2MaxPenetration) ? -1 : ((ammo1MaxPenetration == ammo2MaxPenetration) ? 0 : 1);
    }

    private int vehicleDynamicComparator(VehicleProfile vehicle1, VehicleProfile vehicle2) {
        return Double.compare(countEngineWTRation(vehicle2), countEngineWTRation(vehicle1));
    }

    private int vehicleAmmoComparator(VehicleProfile vehicle1, VehicleProfile vehicle2) {
        return ammoComparator(findVehicleOriginalAmmo(vehicle2), findVehicleOriginalAmmo(vehicle1));
    }

    private int vehicleViewRangeComparator(VehicleProfile vehicle1, VehicleProfile vehicle2) {
        return Integer.compare(vehicle2.getTurret().getViewRange(), vehicle1.getTurret().getViewRange());
    }

    private double countEngineWTRation(VehicleProfile vehicle) {
        if(Objects.nonNull(vehicle) && Objects.nonNull(vehicle.getEngine()) && vehicle.getWeight() != 0) {
            return Double.longBitsToDouble(vehicle.getEngine().getPower() / (vehicle.getWeight() / 1000));
        }
        return 0;
    }
}
